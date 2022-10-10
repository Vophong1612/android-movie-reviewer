package com.example.data.di

import dagger.Module
import dagger.Provides
import vn.gst.sun.lib.repositories.MovieRepository
import vn.gst.sun.lib.usecases.GetMovieDetail
import vn.gst.sun.lib.usecases.GetPopularMovies
import vn.gst.sun.lib.usecases.GetSimilarMovie
import vn.gst.sun.lib.usecases.GetTopRatedMovies

@Module
class UseCasesModule {

    @Provides
    fun providePopularMovies(repository: MovieRepository) = GetPopularMovies(repository)

    @Provides
    fun provideMovieDetail(repository: MovieRepository) = GetMovieDetail(repository)

    @Provides
    fun provideTopRatedMovies(repository: MovieRepository) = GetTopRatedMovies(repository)

    @Provides
    fun provideSimilarMovie(repository: MovieRepository) = GetSimilarMovie(repository)
}