package vn.gst.sun.moviestatistic.framework.di.presentation

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import vn.gst.sun.moviestatistic.presenter.moviedetail.MovieDetailFragment
import vn.gst.sun.moviestatistic.presenter.moviedetail.MovieDetailViewModel

@Module
abstract class MovieDetailModule {
    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeMovieDetailFragment(): MovieDetailFragment

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    abstract fun provideMovieDetailViewModel(movieDetailViewModel: MovieDetailViewModel): ViewModel
}