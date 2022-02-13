package com.interview.geolocationjm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.interview.geolocationjm.App.Navigation.navigatorHolder
import com.interview.geolocationjm.App.Navigation.router
import com.interview.geolocationjm.ui.map.MainScreen

class MapsActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityMapsBinding

    private val navigator = AppNavigator(this, android.R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState ?: router.newRootScreen(MainScreen)

        /*binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }*/
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}