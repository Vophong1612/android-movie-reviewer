package vn.gst.sun.moviestatistic.framework.di.presentation

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.gst.sun.moviestatistic.presenter.home.HomeFragment

@Module
abstract class HomeModule {
    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeHomeFragment(): HomeFragment
}