package vn.gst.sun.moviestatistic.di.application.context

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import vn.gst.sun.moviestatistic.MyApplication

@Component(modules = [ContextModule::class])
@AppContextScoped
interface ContextComponent {
    fun context(): Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: MyApplication): ContextComponent
    }
}