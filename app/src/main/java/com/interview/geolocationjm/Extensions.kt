package com.interview.geolocationjm

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

fun Fragment.arguments(vararg arguments: Pair<String, Any>): Fragment {
    this.arguments = bundleOf(*arguments)
    return this
}