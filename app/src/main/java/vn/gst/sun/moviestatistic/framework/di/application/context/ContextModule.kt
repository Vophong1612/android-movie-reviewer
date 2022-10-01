package vn.gst.sun.moviestatistic.framework.di.application.context

import android.content.Context
import dagger.Module
import dagger.Provides
import vn.gst.sun.moviestatistic.MyApplication

@Module
class ContextModule {
    @Provides
    fun provideContext(application: MyApplication): Context = application.applicationContext
}