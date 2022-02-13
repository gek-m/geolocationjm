package com.interview.geolocationjm.ui.markersList.adapter

import androidx.recyclerview.widget.DiffUtil
import com.google.android.gms.maps.model.Marker

object MarkersDiffUtil: DiffUtil.ItemCallback<Marker>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: Marker, newItem: Marker): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Marker, newItem: Marker): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: Marker, newItem: Marker) = payload
}