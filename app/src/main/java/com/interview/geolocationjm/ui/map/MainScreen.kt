package com.interview.geolocationjm.ui.map

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object MainScreen: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        MainFragment.newInstance()
}