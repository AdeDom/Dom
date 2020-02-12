package com.adedom.library.util

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.adedom.library.extension.failed

abstract class PathiphonActivity : AppCompatActivity() {

    private lateinit var mLocationSwitchStateReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            val result = ContextCompat
                .checkSelfPermission(baseContext, Manifest.permission.GET_ACCOUNTS)
            if (result != PackageManager.PERMISSION_GRANTED)
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    1994
                )
        }

        mLocationSwitchStateReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                if (LocationManager.PROVIDERS_CHANGED_ACTION == intent.action) {
                    val locationManager =
                        context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
                    val isGpsEnabled =
                        locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) //NETWORK_PROVIDER

                    if (!isGpsEnabled)
                        locationSetting()
                }
            }
        }

        locationSetting()
    }

    override fun onResume() {
        super.onResume()

        true.broadcastReceiver()
    }

    override fun onPause() {
        super.onPause()

        false.broadcastReceiver()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1994 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
            baseContext.failed()
            finishAffinity()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val isLocationProviderEnabled = Settings.Secure.isLocationProviderEnabled(
            baseContext.contentResolver,
            LocationManager.GPS_PROVIDER
        )
        if (!isLocationProviderEnabled && requestCode == 2537) {
            baseContext.failed()
            finishAffinity()
        }
    }

    private fun Boolean.broadcastReceiver() {
        if (this) {
            val filter = IntentFilter(LocationManager.PROVIDERS_CHANGED_ACTION)
            filter.addAction(Intent.ACTION_PROVIDER_CHANGED)
            registerReceiver(mLocationSwitchStateReceiver, filter)
        } else {
            unregisterReceiver(mLocationSwitchStateReceiver)
        }
    }

    private fun locationSetting() {
        val isLocationProviderEnabled = Settings.Secure.isLocationProviderEnabled(
            baseContext.contentResolver,
            LocationManager.GPS_PROVIDER
        )
        if (!isLocationProviderEnabled) {
            startActivityForResult(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS), 2537)
            finishAffinity()
        }
    }

}
