package vn.gst.sun.lib.repository

import io.reactivex.Flowable
import vn.gst.sun.lib.data.Movie

interface MovieRepository {
    fun getPopularMovies(): Flowable<List<Movie>>

//    fun getMovieDetail(movieId: Int): Movie?
}