package vn.gst.sun.moviestatistic.framework.repository

import vn.gst.sun.lib.usecase.GetMovieDetail
import vn.gst.sun.lib.usecase.GetPopularMovies

data class UseCases(
    val getPopularMovies: GetPopularMovies,
    val getMovieDetail: GetMovieDetail
)