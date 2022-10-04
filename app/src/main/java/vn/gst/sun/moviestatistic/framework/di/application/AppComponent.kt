package vn.gst.sun.moviestatistic.framework.di.application

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import vn.gst.sun.moviestatistic.MyApplication
import vn.gst.sun.moviestatistic.framework.di.activity.ActivityBindingModule
import vn.gst.sun.moviestatistic.framework.di.application.context.ContextComponent
import vn.gst.sun.moviestatistic.framework.di.presentation.ViewModelModule

@AppScope
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        UseCasesModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class
    ],
    dependencies = [ContextComponent::class]
)
interface AppComponent : AndroidInjector<MyApplication> {

    @Component.Factory
    interface Factory {
        fun create(
            contextComponent: ContextComponent
        ): AppComponent
    }
}