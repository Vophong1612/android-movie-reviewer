package com.example.data.di

import dagger.Component
import vn.gst.sun.lib.usecases.GetMovieDetail
import vn.gst.sun.lib.usecases.GetPopularMovies
import vn.gst.sun.lib.usecases.GetSimilarMovie
import vn.gst.sun.lib.usecases.GetTopRatedMovies

@Component(
    modules = [
        DataModule::class,
        UseCasesModule::class
    ]
)
@DataScope
interface DataComponent {

    fun popularMovies(): GetPopularMovies

    fun movieDetail(): GetMovieDetail

    fun topRatedMovies(): GetTopRatedMovies

    fun similarMovie(): GetSimilarMovie

    @Component.Factory
    interface Factory {
        fun create(): DataComponent
    }
}