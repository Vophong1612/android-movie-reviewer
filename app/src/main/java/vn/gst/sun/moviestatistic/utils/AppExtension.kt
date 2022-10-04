package vn.gst.sun.moviestatistic.utils

import androidx.fragment.app.Fragment
import vn.gst.sun.moviestatistic.presenter.NavHost

fun Fragment.findNavHost(): NavHost? {
    val parent = parentFragment ?: return if (activity is NavHost) {
        activity as NavHost
    } else {
        null
    }

    return if (parent is NavHost) {
        parent
    } else {
        parent.findNavHost()
    }
}