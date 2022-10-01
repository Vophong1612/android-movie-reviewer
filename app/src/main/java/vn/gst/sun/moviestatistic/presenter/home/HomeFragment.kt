package vn.gst.sun.moviestatistic.presenter.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.core.os.bundleOf
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeFragment: DaggerFragment() {

    companion object {
        const val TAG = "HomeFragment"

        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            fragment.arguments = bundleOf()
            return fragment
        }
    }

    @Inject
    lateinit var appContext: Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(appContext).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                HomeFragmentView()
            }
        }
    }
}