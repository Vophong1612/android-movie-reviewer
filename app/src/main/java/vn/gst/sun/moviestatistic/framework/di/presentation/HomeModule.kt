package vn.gst.sun.moviestatistic.framework.di.presentation

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import vn.gst.sun.moviestatistic.presenter.home.HomeFragment
import vn.gst.sun.moviestatistic.presenter.home.HomeViewModel

@Module
abstract class HomeModule {
    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeHomeFragment(): HomeFragment

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun mainViewModel(mainViewModel: HomeViewModel): ViewModel
}