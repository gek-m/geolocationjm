package com.interview.geolocationjm.ui.markersList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.gms.maps.model.Marker
import com.interview.geolocationjm.databinding.MarkersFragmentBinding
import com.interview.geolocationjm.ui.MarkersViewModel
import com.interview.geolocationjm.ui.markersList.adapter.MarkersAdapter

class MarkersFragment : Fragment(), MarkersAdapter.Delegate {

    companion object {
        fun newInstance(): Fragment = MarkersFragment()
    }

    private val viewModel: MarkersViewModel by activityViewModels()
    private lateinit var binding: MarkersFragmentBinding
    private val adapter = MarkersAdapter(this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MarkersFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.markersList.adapter = adapter

        viewModel.markers.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun onMarkerSelect(marker: Marker) {
        viewModel.showToEditMarker(marker)
    }
}