package vn.gst.sun.moviestatistic.framework.di.activity

import androidx.appcompat.app.AppCompatActivity
import dagger.BindsInstance
import dagger.Subcomponent
//import vn.gst.sun.moviestatistic.framework.di.presentation.PresentationComponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

//    fun newPresentationComponent(): PresentationComponent

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: AppCompatActivity): Builder
        fun build(): ActivityComponent
    }

}