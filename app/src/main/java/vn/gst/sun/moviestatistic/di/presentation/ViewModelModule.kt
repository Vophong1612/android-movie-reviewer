package vn.gst.sun.moviestatistic.di.presentation

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import vn.gst.sun.moviestatistic.presenter.viewmodel.ViewModelFactory

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factor: ViewModelFactory): ViewModelProvider.Factory
}