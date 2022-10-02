package vn.gst.sun.moviestatistic.framework.di.presentation

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import vn.gst.sun.moviestatistic.presenter.home.HomeViewModel

@Module
abstract class MainModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun mainViewModel(mainViewModel: HomeViewModel): ViewModel
}