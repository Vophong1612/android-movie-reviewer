package vn.gst.sun.moviestatistic

import javax.inject.Inject
import vn.gst.sun.lib.usecases.GetMovieDetail
import vn.gst.sun.lib.usecases.GetPopularMovies
import vn.gst.sun.lib.usecases.GetSimilarMovie
import vn.gst.sun.lib.usecases.GetTopRatedMovies
import vn.gst.sun.moviestatistic.di.application.AppScope

@AppScope
data class UseCases @Inject constructor(
    val getPopularMovies: GetPopularMovies,
    val getMovieDetail: GetMovieDetail,
    val getTopRatedMovies: GetTopRatedMovies,
    val getSimilarMovie: GetSimilarMovie
)