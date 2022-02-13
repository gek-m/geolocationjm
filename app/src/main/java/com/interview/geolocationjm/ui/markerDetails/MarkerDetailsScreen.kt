package com.interview.geolocationjm.ui.markerDetails

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class MarkerDetailsScreen(private val gMapId: String): FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        MarkerDetailsFragment.newInstance(gMapId)
}