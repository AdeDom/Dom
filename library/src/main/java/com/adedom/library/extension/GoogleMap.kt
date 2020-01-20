package com.adedom.library.extension

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*

var myMarker: Marker? = null
var myCircle: Circle? = null
//GoogleMapActivity.sGoogleMap!!.setMarker(
//    latLng,
//    BitmapDescriptorFactory.fromResource(R.drawable.ic_player),
//    player.name!!,
//    getLevel(player.level)
//)
fun GoogleMap.setMarker(
    latLng: LatLng,
    icon: BitmapDescriptor,
    title: String? = null,
    snippet: String? = null
) {
    val marker = this.addMarker(
        MarkerOptions()
            .position(latLng)
            .icon(icon)
            .title(title)
            .snippet(snippet)
    )
    myMarker = marker
}

//GoogleMapActivity.sGoogleMap!!.setCircle( latLng, CIRCLE_ONE_HUNDRED_METER)
fun GoogleMap.setCircle(latLng: LatLng, radius: Double) {
    val circle = this.addCircle(
        CircleOptions().center(latLng)
            .radius(radius)
            .fillColor(com.adedom.library.R.color.colorWhite)
            .strokeColor(android.R.color.white)
            .strokeWidth(5f)
    )
    myCircle = circle
}

//sGoogleMap!!.setMarkerConstant(druBkk, druIcon, DRU_TITLE, DRU_SNIPPET)
fun GoogleMap.setMarkerConstant(
    latLng: LatLng,
    icon: BitmapDescriptor,
    title: String? = null,
    snippet: String? = null
) {
    this.addMarker(
        MarkerOptions()
            .position(latLng)
            .icon(icon)
            .title(title)
            .snippet(snippet)
    )
}
