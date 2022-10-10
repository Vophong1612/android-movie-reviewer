package com.example.data.service.service

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.data.data.GetPopularMoviesResponse
import com.example.data.data.GetSimilarMoviesResponse
import com.example.data.data.GetTopRatedMoviesResponse
import com.example.data.data.MovieDetailResponse

interface MovieDataService {
    @GET("movie/popular")
    fun getPopularMovies(): Flowable<com.example.data.data.GetPopularMoviesResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(): Flowable<com.example.data.data.GetTopRatedMoviesResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetail(@Path("movie_id") movieId: Int): Flowable<com.example.data.data.MovieDetailResponse>

    @GET("movie/{movie_id}/similar")
    fun getSimilarMovie(@Path("movie_id") movieId: Int): Flowable<com.example.data.data.GetSimilarMoviesResponse>
}