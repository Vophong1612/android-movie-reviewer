package vn.gst.sun.moviestatistic.presenter.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import vn.gst.sun.moviestatistic.utils.Navigator
import vn.gst.sun.moviestatistic.utils.findNavHost

class HomeFragment : DaggerFragment() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    @Inject
    lateinit var navigator: Navigator

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

    init {
        lifecycleScope.launchWhenCreated {
            homeViewModel.getPopularMovies()
            homeViewModel.getTopRatedMovies()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(appContext).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                HomeFragmentView(
                    viewModel = homeViewModel,
                    onMovieItemClick = {
                        onMovieItemClick(it)
                    }
                )
            }
        }
    }

    private fun onMovieItemClick(movieId: Int) {
        navigator.toMovieDetail(findNavHost(), movieId)
    }


}