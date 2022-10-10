package vn.gst.sun.moviestatistic.presenter.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import vn.gst.sun.lib.data.Movie
import vn.gst.sun.moviestatistic.presenter.home.view.PopularMoviesView
import vn.gst.sun.moviestatistic.presenter.home.view.TopRatedMoviesView

@SuppressLint("UnrememberedMutableState")
@Composable
fun HomeFragmentView(
    popularMovies: SnapshotStateList<Movie>,
    topRatedMovies: SnapshotStateList<Movie>,
    isLoading: Boolean,
    onMovieItemClick: (movieId: Int) -> Unit,
    onRefresh: () -> Unit
) {
    SwipeRefresh(state = rememberSwipeRefreshState(isRefreshing = isLoading),
        onRefresh = onRefresh) {

        LazyColumn(
            modifier = Modifier.background(Color.Black)
        ) {
            item {
                PopularMoviesView(
                    popularMovies = popularMovies,
                    onMovieItemClick = onMovieItemClick
                )
            }

            item {
                TopRatedMoviesView(
                    topRatedMovies = topRatedMovies,
                    modifier = Modifier.padding(top = 20.dp),
                    onMovieItemClick = onMovieItemClick
                )
            }
        }
    }
}
