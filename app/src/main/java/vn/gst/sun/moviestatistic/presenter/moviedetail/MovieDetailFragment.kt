package vn.gst.sun.moviestatistic.presenter.moviedetail

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

class MovieDetailFragment : DaggerFragment() {

    companion object {
        private const val KEY_MOVIE_ID = "bundle_movie_id"

        const val TAG = "MovieDetailFragment"

        fun newInstance(movieId: Int): MovieDetailFragment {
            val fragment = MovieDetailFragment()
            fragment.arguments = bundleOf(
                KEY_MOVIE_ID to movieId
            )
            return fragment
        }
    }

    @Inject
    lateinit var appContext: Context

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var movieDetailViewModel: MovieDetailViewModel

    private var movieId: Int = 0

    init {
        lifecycleScope.launchWhenCreated {
            movieId = arguments?.getInt(KEY_MOVIE_ID, 0) ?: 0

            movieDetailViewModel.getMovieDetail(movieId = movieId)
            movieDetailViewModel.getSimilarMovie(movieId = movieId)
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
                MovieDetailView(viewModel = movieDetailViewModel,
                    onSimilarMovieClick = {
                        onSimilarMovieItemClick(it)
                    })
            }
        }
    }

    private fun onSimilarMovieItemClick(movieId: Int) {
        navigator.toMovieDetail(findNavHost(), movieId)
    }
}