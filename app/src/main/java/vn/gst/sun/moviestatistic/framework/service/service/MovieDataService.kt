package vn.gst.sun.moviestatistic.framework.service.service

import android.content.Context
import io.reactivex.Flowable
import retrofit2.http.GET
import vn.gst.sun.moviestatistic.framework.service.NetworkProvider
import vn.gst.sun.moviestatistic.framework.service.data.GetPopularMoviesResponse
import vn.gst.sun.moviestatistic.framework.service.data.GetTopRatedMoviesResponse

interface MovieDataService {
    @GET("movie/popular")
    fun getPopularMovies(): Flowable<GetPopularMoviesResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(): Flowable<GetTopRatedMoviesResponse>

    companion object {
        fun create(context: Context): MovieDataService {
            val networkProvider = NetworkProvider.newInstance(context)
            return networkProvider.getService(MovieDataService::class.java)
        }
    }
}