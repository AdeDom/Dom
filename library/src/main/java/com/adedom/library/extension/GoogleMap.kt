package com.adedom.library.extension

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*

fun GoogleMap.addMarkerOptions(
    latLng: LatLng,
    icon: BitmapDescriptor,
    title: String? = null,
    snippet: String? = null
): Marker {
    return this.addMarker(
        MarkerOptions()
            .position(latLng)
            .icon(icon)
            .title(title)
            .snippet(snippet)
    )
}

fun GoogleMap.addCircleOptions(latLng: LatLng, radius: Double): Circle {
    return this.addCircle(
        CircleOptions().center(latLng)
            .radius(radius)
            .fillColor(com.adedom.library.R.color.colorWhite)
            .strokeColor(android.R.color.white)
            .strokeWidth(5f)
    )
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
