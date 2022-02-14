package com.interview.geolocationjm.ui.markersList.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.gms.maps.model.Marker
import com.interview.geolocationjm.databinding.ViewMarkerBinding

class MarkerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val viewBinding: ViewMarkerBinding by viewBinding()

    fun bind(marker: Marker, delegate: MarkersAdapter.Delegate?) {
        with(viewBinding) {
            marker.title?.let {
                titleMarker.text = marker.title
            }
            latitudeMarker.text = marker.position.latitude.toString()
            longitudeMarker.text = marker.position.longitude.toString()

            titleMarker.setOnClickListener {
                delegate?.onMarkerSelect(marker)
            }
        }
    }
}
