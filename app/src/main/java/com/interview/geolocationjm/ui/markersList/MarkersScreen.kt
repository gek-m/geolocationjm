package com.interview.geolocationjm.ui.markersList

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object MarkersScreen: FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        MarkersFragment.newInstance()
}
