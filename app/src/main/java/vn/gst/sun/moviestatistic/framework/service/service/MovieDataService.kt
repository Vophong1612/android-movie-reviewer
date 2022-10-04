package vn.gst.sun.moviestatistic.framework.service.service

import android.content.Context
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import vn.gst.sun.moviestatistic.framework.service.NetworkProvider
import vn.gst.sun.moviestatistic.framework.service.data.GetPopularMoviesResponse
import vn.gst.sun.moviestatistic.framework.service.data.GetSimilarMoviesResponse
import vn.gst.sun.moviestatistic.framework.service.data.GetTopRatedMoviesResponse
import vn.gst.sun.moviestatistic.framework.service.data.MovieDetailResponse
import vn.gst.sun.moviestatistic.framework.service.data.MovieResponse

interface MovieDataService {
    @GET("movie/popular")
    fun getPopularMovies(): Flowable<GetPopularMoviesResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(): Flowable<GetTopRatedMoviesResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetail(@Path("movie_id") movieId: Int): Flowable<MovieDetailResponse>

    @GET("movie/{movie_id}/similar")
    fun getSimilarMovie(@Path("movie_id") movieId: Int): Flowable<GetSimilarMoviesResponse>

    companion object {
        fun create(context: Context): MovieDataService {
            val networkProvider = NetworkProvider.newInstance(context)
            return networkProvider.getService(MovieDataService::class.java)
        }
    }
}