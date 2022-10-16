package com.example.data

import com.example.data.di.DataScope
import javax.inject.Inject
import vn.gst.sun.lib.usecases.GetMovieDetailUseCase
import vn.gst.sun.lib.usecases.GetPopularMoviesUseCase
import vn.gst.sun.lib.usecases.GetSimilarMovieUseCase
import vn.gst.sun.lib.usecases.GetTopRatedMoviesUseCase

@DataScope
data class UseCases @Inject constructor(
    val getPopularMovies: GetPopularMoviesUseCase,
    val getMovieDetail: GetMovieDetailUseCase,
    val getTopRatedMovies: GetTopRatedMoviesUseCase,
    val getSimilarMovie: GetSimilarMovieUseCase
)