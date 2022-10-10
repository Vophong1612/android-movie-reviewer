package vn.gst.sun.lib.repositories

import io.reactivex.Flowable
import vn.gst.sun.lib.data.Movie
import vn.gst.sun.lib.data.MovieDetail

interface MovieRepository {
    fun getPopularMovies(limit: Int = 10): Flowable<List<Movie>>
    fun getTopRatedMovies(limit: Int = 20): Flowable<List<Movie>>
    fun getMovieDetail(movieId: Int): Flowable<MovieDetail>
    fun getSimilarMovies(movieId:Int, limit: Int = 20): Flowable<List<Movie>>
}