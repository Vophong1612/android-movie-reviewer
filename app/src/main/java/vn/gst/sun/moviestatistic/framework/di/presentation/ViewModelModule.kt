package vn.gst.sun.moviestatistic.framework.di.presentation

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import vn.gst.sun.moviestatistic.utils.MyViewModelFactory

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factor: MyViewModelFactory): ViewModelProvider.Factory
}