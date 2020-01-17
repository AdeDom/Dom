package com.adedom.library.extension

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import java.util.*

//markerPlayers.setMarkers(
//    MapActivity.sGoogleMap,
//    latLng,
//    BitmapDescriptorFactory.fromResource(R.drawable.ic_player),
//    item.name!!,
//    getLevel(item.level)
//)
fun ArrayList<Marker>.setMarkers(
    googleMap: GoogleMap?,
    latLng: LatLng,
    icon: BitmapDescriptor,
    title: String? = null,
    snippet: String? = null
) {
    this.add(
        googleMap!!.addMarker(
            MarkerOptions().position(latLng)
                .icon(icon)
                .title(title)
                .snippet(snippet)
        )
    )
}

//markerPlayers.removeMarkers()
fun ArrayList<Marker>.removeMarkers() {
    for (marker in this) marker.remove()
    this.clear()
}

