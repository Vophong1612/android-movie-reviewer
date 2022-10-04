package vn.gst.sun.moviestatistic.presenter

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager

interface NavHost {
    @IdRes
    fun containerId(): Int

    fun navHostFragmentManager(): FragmentManager
}