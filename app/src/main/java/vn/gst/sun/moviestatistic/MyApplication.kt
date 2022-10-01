package vn.gst.sun.moviestatistic

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject
import vn.gst.sun.moviestatistic.framework.di.application.DaggerAppComponent
import vn.gst.sun.moviestatistic.framework.di.application.context.DaggerContextComponent

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

        return DaggerAppComponent.factory().create(contextComponent)
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