package vn.gst.sun.moviestatistic.framework.di.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import vn.gst.sun.moviestatistic.presenter.MainActivity

@Module
abstract class ActivityModule {

//    @ActivityScope
//    @Binds
//    abstract fun screensNavigator(screensNavigatorImpl: ScreensNavigatorImpl): ScreensNavigator

    companion object {
        @Provides
        fun layoutInflater(activity: AppCompatActivity) = LayoutInflater.from(activity)

        @Provides
        fun fragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager
    }

}