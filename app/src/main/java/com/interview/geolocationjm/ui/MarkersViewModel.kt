package com.interview.geolocationjm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.Marker
import com.interview.geolocationjm.App.Navigation.router
import com.interview.geolocationjm.ui.markerDetails.MarkerDetailsScreen
import com.interview.geolocationjm.ui.markersList.MarkersScreen

class MarkersViewModel : ViewModel() {

    private val _markers = MutableLiveData<ArrayList<Marker>>()
    val markers: LiveData<ArrayList<Marker>> = _markers

    fun addMarkers(gMapMarkers: ArrayList<Marker>) {
        _markers.value = gMapMarkers
    }

    fun addMarker(gMapMarker: Marker) {
        if (_markers.value == null) _markers.value = ArrayList()
        _markers.value?.add(gMapMarker)
    }

    fun showToEditMarker(gMapMarker: Marker){
        router.navigateTo(MarkerDetailsScreen(gMapMarker.id))
    }

    fun cancelMarkerDetails(){
        router.backTo(MarkersScreen)
    }

    fun getMarkerById(markerId: String): Marker?{
        var result: Marker? = null
        val index = getMarker(markerId)
        index?.let {  result = _markers.value?.get(index) }
        return result
    }

    fun saveMarkerDetails(marker: Marker){
        val index = getMarker(marker.id)
        index?.let { i ->
            _markers.value?.let {
                it[i].title = marker.title
            }
        }
        router.backTo(MarkersScreen)
    }

    private fun getMarker(markerId: String): Int? =
        _markers.value?.indexOfFirst { m -> m.id == markerId }
}