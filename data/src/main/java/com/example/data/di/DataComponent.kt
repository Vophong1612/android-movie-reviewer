package com.example.data.di

import com.example.data.UseCases
import dagger.Component
import vn.gst.sun.lib.usecases.GetMovieDetailUseCase
import vn.gst.sun.lib.usecases.GetPopularMoviesUseCase
import vn.gst.sun.lib.usecases.GetSimilarMovieUseCase
import vn.gst.sun.lib.usecases.GetTopRatedMoviesUseCase

@Component(
    modules = [DataModule::class]
)
@DataScope
interface DataComponent {

    fun usecases(): UseCases

    @Component.Factory
    interface Factory {
        fun create(): DataComponent
    }
}