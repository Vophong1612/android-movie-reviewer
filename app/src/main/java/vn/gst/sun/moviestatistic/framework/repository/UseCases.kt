package vn.gst.sun.moviestatistic.framework.repository

import vn.gst.sun.lib.usecase.GetMovieDetail
import vn.gst.sun.lib.usecase.GetPopularMovies
import vn.gst.sun.lib.usecase.GetTopRatedMovies

data class UseCases(
    val getPopularMovies: GetPopularMovies,
    val getMovieDetail: GetMovieDetail,
    val getTopRatedMovies: GetTopRatedMovies
)