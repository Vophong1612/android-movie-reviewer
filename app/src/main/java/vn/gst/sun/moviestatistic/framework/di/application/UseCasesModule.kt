package vn.gst.sun.moviestatistic.framework.di.application

import dagger.Module
import dagger.Provides
import vn.gst.sun.lib.repository.MovieRepository
import vn.gst.sun.lib.usecase.GetMovieDetail
import vn.gst.sun.lib.usecase.GetPopularMovies
import vn.gst.sun.lib.usecase.GetTopRatedMovies
import vn.gst.sun.moviestatistic.framework.repository.UseCases

@Module
class UseCasesModule {

    @Provides
    fun providePopularMovies(repository: MovieRepository) = GetPopularMovies(repository)

    @Provides
    fun provideMovieDetail(repository: MovieRepository) = GetMovieDetail(repository)

    @Provides
    fun provideTopRatedMovies(repository: MovieRepository) = GetTopRatedMovies(repository)

    @Provides
    @AppScope
    fun provideUseCases(
        getPopularMovies: GetPopularMovies,
        getMovieDetail: GetMovieDetail,
        getTopRatedMovies: GetTopRatedMovies
    ) = UseCases(getPopularMovies, getMovieDetail, getTopRatedMovies)
}