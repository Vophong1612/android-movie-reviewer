package vn.gst.sun.lib.repository

import io.reactivex.Flowable
import vn.gst.sun.lib.data.Movie

interface MovieRepository {
    fun getPopularMovies(limit: Int = 10): Flowable<List<Movie>>
    fun getTopRatedMovies(limit: Int = 20): Flowable<List<Movie>>
//    fun getMovieDetail(movieId: Int): Movie?
}