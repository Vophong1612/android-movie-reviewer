package vn.gst.sun.moviestatistic.di.application.context

import android.content.Context
import dagger.Module
import dagger.Provides
import vn.gst.sun.moviestatistic.MyApplication

@Module
class ContextModule {
    @Provides
    @AppContextScoped
    fun provideContext(application: MyApplication): Context = application.applicationContext
}