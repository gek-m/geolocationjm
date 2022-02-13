package com.interview.geolocationjm.ui.markerDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.gms.maps.model.Marker
import com.interview.geolocationjm.arguments
import com.interview.geolocationjm.databinding.MarkerDetailsFragmentBinding
import com.interview.geolocationjm.ui.MarkersViewModel

class MarkerDetailsFragment : Fragment() {

    companion object {
        private const val ARG_MARKER_ID = "argument_marker_id"
        fun newInstance(gMapId: String) = MarkerDetailsFragment().arguments(
            ARG_MARKER_ID to gMapId
        )
    }

    private val viewModel: MarkersViewModel by activityViewModels()
    private lateinit var binding: MarkerDetailsFragmentBinding

    private val gMapId: String by lazy {
        arguments?.getString(ARG_MARKER_ID).orEmpty()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MarkerDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val marker: Marker? = viewModel.getMarkerById(gMapId)
        with(binding) {
            marker?.let {
                markerName.setText(marker.title)
            }
            btnCancel.setOnClickListener {
                viewModel.cancelMarkerDetails()
            }
            btnSave.setOnClickListener {
                marker?.let {
                    marker.title = markerName.text.toString()
                    viewModel.saveMarkerDetails(marker)
                }
            }
        }
    }
}