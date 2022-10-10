package vn.gst.sun.moviestatistic.di.application

import com.example.data.di.DataComponent
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import vn.gst.sun.moviestatistic.MyApplication
import vn.gst.sun.moviestatistic.di.activity.ActivityBindingModule
import vn.gst.sun.moviestatistic.di.application.context.ContextComponent
import vn.gst.sun.moviestatistic.di.presentation.ViewModelModule

@AppScope
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class
    ],
    dependencies = [ContextComponent::class, DataComponent::class]
)
interface AppComponent : AndroidInjector<MyApplication> {

    @Component.Factory
    interface Factory {
        fun create(
            contextComponent: ContextComponent,
            dataComponent: DataComponent
        ): AppComponent
    }
}