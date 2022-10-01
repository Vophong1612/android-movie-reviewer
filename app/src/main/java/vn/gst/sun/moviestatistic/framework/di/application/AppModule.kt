package vn.gst.sun.moviestatistic.framework.di.application

import android.content.Context
import dagger.Module
import dagger.Provides
import vn.gst.sun.lib.repository.MovieRepository
import vn.gst.sun.moviestatistic.framework.repository.MovieRepositoryImpl
import vn.gst.sun.moviestatistic.framework.service.NetworkProvider
import vn.gst.sun.moviestatistic.framework.service.service.MovieDataService

@Module
class AppModule {
    @Provides
    @AppScope
    fun provideNetworkProvider(context: Context): NetworkProvider = NetworkProvider.newInstance(context)

    @Provides
    @AppScope
    fun provideMovieDataService(networkProvider: NetworkProvider): MovieDataService = networkProvider.getService(
        MovieDataService::class.java)

    @Provides
    @AppScope
    fun provideMovieRepository(movieDataService: MovieDataService): MovieRepository = MovieRepositoryImpl(movieDataService)

}