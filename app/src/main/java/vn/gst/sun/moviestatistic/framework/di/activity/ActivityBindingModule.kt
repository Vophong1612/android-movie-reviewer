package vn.gst.sun.moviestatistic.framework.di.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.gst.sun.moviestatistic.framework.di.presentation.HomeModule
import vn.gst.sun.moviestatistic.framework.di.presentation.MainModule
import vn.gst.sun.moviestatistic.presenter.MainActivity

@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            MainModule::class,
            HomeModule::class
        ]
    )
    internal abstract fun contributeMainActivity(): MainActivity
}