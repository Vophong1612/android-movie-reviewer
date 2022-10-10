package vn.gst.sun.moviestatistic.utils

import javax.inject.Inject
import vn.gst.sun.moviestatistic.di.application.AppScope
import vn.gst.sun.moviestatistic.presenter.NavHost
import vn.gst.sun.moviestatistic.presenter.moviedetail.MovieDetailFragment

@AppScope
class Navigator @Inject constructor() {

    fun toMovieDetail(navHost: NavHost?, movieId: Int) {
        navHost?.let { host ->
            host.navHostFragmentManager().beginTransaction()
                .replace(
                    host.containerId(),
                    MovieDetailFragment.newInstance(movieId)
                )
                .addToBackStack(MovieDetailFragment.TAG)
                .commit()
        }
    }
}