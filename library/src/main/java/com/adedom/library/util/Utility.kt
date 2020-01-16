package com.adedom.library.util

import com.adedom.library.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*
import java.text.SimpleDateFormat
import java.util.*

//getDateTime(KEY_DATE)
fun getDateTime(keyDateTime: String): String =
    SimpleDateFormat(keyDateTime, Locale.ENGLISH).format(Calendar.getInstance().time)

var myLocation: Marker? = null
var myCircle: Circle? = null
//setMarker(
//    MapActivity.sGoogleMap!!,
//    latLng,
//    BitmapDescriptorFactory.fromResource(R.drawable.ic_player),
//    player.name!!,
//    getLevel(player.level)
//)
fun setMarker(
    googleMap: GoogleMap?,
    latLng: LatLng,
    icon: BitmapDescriptor,
    title: String? = null,
    snippet: String? = null
) {
    myLocation = googleMap!!.addMarker(
        MarkerOptions()
            .position(latLng)
            .icon(icon)
            .title(title)
            .snippet(snippet)
    )
}

//setCircle(MapActivity.sGoogleMap, latLng, RADIUS_ONE_HUNDRED_METER)
fun setCircle(googleMap: GoogleMap?, latLng: LatLng, radius: Double) {
    myCircle = googleMap!!.addCircle(
        CircleOptions().center(latLng)
            .radius(radius)
            .fillColor(R.color.colorWhite)
            .strokeColor(android.R.color.white)
            .strokeWidth(5f)
    )
}

