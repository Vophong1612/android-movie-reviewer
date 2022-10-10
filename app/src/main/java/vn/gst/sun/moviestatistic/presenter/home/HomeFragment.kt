package vn.gst.sun.moviestatistic.presenter.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import vn.gst.sun.lib.data.Movie
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

    private val popularMovies = mutableStateListOf<Movie>()

    private val topRatedMovies = mutableStateListOf<Movie>()

    private val isLoading = mutableStateOf(false)

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
                    popularMovies = popularMovies,
                    topRatedMovies = topRatedMovies,
                    isLoading = isLoading.value,
                    onMovieItemClick = {
                        onMovieItemClick(it)
                    },
                    onRefresh = {
                        homeViewModel.getPopularMovies()
                        homeViewModel.getTopRatedMovies()
                    }
                )
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.popularMovies.observe(viewLifecycleOwner) {
            popularMovies.clear()
            popularMovies.addAll(it)
        }

        homeViewModel.topRatedMovies.observe(viewLifecycleOwner) {
            topRatedMovies.clear()
            topRatedMovies.addAll(it)
        }

        homeViewModel.isLoading.observe(viewLifecycleOwner) {
            isLoading.value = it
        }

        homeViewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(appContext, "error occur", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onMovieItemClick(movieId: Int) {
        navigator.toMovieDetail(findNavHost(), movieId)
    }
}