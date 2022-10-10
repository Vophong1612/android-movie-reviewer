package vn.gst.sun.moviestatistic

import android.app.Application
import com.example.data.di.DaggerDataComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject
import vn.gst.sun.moviestatistic.di.application.DaggerAppComponent
import vn.gst.sun.moviestatistic.di.application.context.DaggerContextComponent

class MyApplication: Application(), HasAndroidInjector {

    @Inject
    @Volatile
    @JvmField
    var androidInjector: DispatchingAndroidInjector<Any>? = null

    override fun onCreate() {
        super.onCreate()

        injectIfNecessary()
    }

    override fun androidInjector(): AndroidInjector<Any> {
        injectIfNecessary()

        return androidInjector as AndroidInjector<Any>
    }

    private fun applicationInjector(): AndroidInjector<MyApplication> {
        val contextComponent = DaggerContextComponent.factory().create(this)

        val dataComponent = DaggerDataComponent.factory().create()

        return DaggerAppComponent.factory().create(contextComponent, dataComponent)
    }

    private fun injectIfNecessary() {
        if (androidInjector == null) {
            synchronized(this) {
                if (androidInjector == null) {
                    val applicationInjector = applicationInjector()
                    applicationInjector.inject(this)
                    if (androidInjector == null) {
                        throw IllegalStateException(
                            "The AndroidInjector returned from applicationInjector() did not inject the "
                                    + "DaggerApplication"
                        )
                    }
                }
            }
        }
    }
}