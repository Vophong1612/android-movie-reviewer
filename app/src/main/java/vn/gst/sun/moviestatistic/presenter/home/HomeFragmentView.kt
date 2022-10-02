package vn.gst.sun.moviestatistic.presenter.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import vn.gst.sun.moviestatistic.presenter.home.view.PopularMoviesView
import vn.gst.sun.moviestatistic.presenter.home.view.TopRatedMoviesView

@Composable
fun HomeFragmentView(
    viewModel: HomeViewModel
) {
    //Popular movies
    val popularMovies = viewModel.popularMovies.observeAsState(listOf()).value

    //Top rated movies
    val topRatedMovies = viewModel.topRatedMovies.observeAsState(listOf()).value

    val isRefreshing by viewModel.isLoading.observeAsState(false)

    SwipeRefresh(state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
        onRefresh = {
            viewModel.getPopularMovies()
            viewModel.getTopRatedMovies()
        }) {

        LazyColumn(
            modifier = Modifier.background(Color.Black)
        ) {
            item {
                PopularMoviesView(popularMovies = popularMovies)
            }

            item {
                TopRatedMoviesView(
                    topRatedMovies = topRatedMovies,
                    modifier = Modifier.padding(top = 20.dp)
                )
            }
        }
    }
}
