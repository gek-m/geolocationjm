package com.interview.geolocationjm.ui.markersList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.google.android.gms.maps.model.Marker
import com.interview.geolocationjm.R.layout.view_marker

class MarkersAdapter(private val delegate: Delegate?) :
    ListAdapter<Marker, MarkerViewHolder>(MarkersDiffUtil) {

    interface Delegate {
        fun onMarkerSelect(marker: Marker)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarkerViewHolder =
        MarkerViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(view_marker, parent, false)
        )

    override fun onBindViewHolder(holder: MarkerViewHolder, position: Int) =
        holder.bind(getItem(position), delegate)
}