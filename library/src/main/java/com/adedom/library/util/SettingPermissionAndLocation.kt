package com.adedom.library.util

import android.Manifest
import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class SettingPermissionAndLocation : AppCompatActivity() {

    init {
        requestPermission()
        locationListener()
        locationSetting()
    }

    companion object {
        private lateinit var mLocationSwitchStateReceiver: BroadcastReceiver

        fun Activity.locationListener(boolean: Boolean) {
            if (boolean) {
                val filter = IntentFilter(LocationManager.PROVIDERS_CHANGED_ACTION)
                filter.addAction(Intent.ACTION_PROVIDER_CHANGED)
                this.registerReceiver(mLocationSwitchStateReceiver, filter)
            } else {
                this.unregisterReceiver(mLocationSwitchStateReceiver)
            }
        }
    }

    private fun requestPermission() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            val result =
                ContextCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS)
            val permission = result == PackageManager.PERMISSION_GRANTED
            if (!permission) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    1
                )
            }
        }
    }

    private fun locationListener() {
        mLocationSwitchStateReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                if (LocationManager.PROVIDERS_CHANGED_ACTION == intent.action) {
                    val locationManager =
                        context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
                    val isGpsEnabled =
                        locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) //NETWORK_PROVIDER

                    if (!isGpsEnabled) {
                        locationSetting()
                    }
                }
            }
        }
    }

    private fun locationSetting() {
        if (!verifyGPS()) {
            this.startActivityForResult(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS), 1234)
            this.finishAffinity()
        }
    }

    private fun verifyGPS(): Boolean {
        val contentResolver = this.contentResolver
        return Settings.Secure.isLocationProviderEnabled(
            contentResolver,
            LocationManager.GPS_PROVIDER
        )
    }
}
