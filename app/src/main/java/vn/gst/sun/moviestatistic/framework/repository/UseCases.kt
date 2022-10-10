package vn.gst.sun.moviestatistic.framework.repository

import javax.inject.Inject
import vn.gst.sun.lib.usecase.GetMovieDetail
import vn.gst.sun.lib.usecase.GetPopularMovies
import vn.gst.sun.lib.usecase.GetSimilarMovie
import vn.gst.sun.lib.usecase.GetTopRatedMovies
import vn.gst.sun.moviestatistic.framework.di.application.AppScope

@AppScope
data class UseCases @Inject constructor(
    val getPopularMovies: GetPopularMovies,
    val getMovieDetail: GetMovieDetail,
    val getTopRatedMovies: GetTopRatedMovies,
    val getSimilarMovie: GetSimilarMovie
)