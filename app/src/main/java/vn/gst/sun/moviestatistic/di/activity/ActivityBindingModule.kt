package vn.gst.sun.moviestatistic.di.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.gst.sun.moviestatistic.di.presentation.HomeModule
import vn.gst.sun.moviestatistic.di.presentation.MovieDetailModule
import vn.gst.sun.moviestatistic.presenter.MainActivity

@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            HomeModule::class,
            MovieDetailModule::class
        ]
    )
    internal abstract fun contributeMainActivity(): MainActivity
}