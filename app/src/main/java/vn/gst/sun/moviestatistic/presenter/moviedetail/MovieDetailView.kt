package vn.gst.sun.moviestatistic.presenter.moviedetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import vn.gst.sun.lib.data.MovieDetail
import vn.gst.sun.moviestatistic.presenter.moviedetail.view.MoviesDetailInfoView
import vn.gst.sun.moviestatistic.presenter.moviedetail.view.MoviesDetailOverviewView
import vn.gst.sun.moviestatistic.presenter.moviedetail.view.MoviesDetailTopImageView
import vn.gst.sun.moviestatistic.presenter.moviedetail.view.SimilarMoviesView

@Composable
fun MovieDetailView(
    viewModel: MovieDetailViewModel,
    onSimilarMovieClick: (Int) -> Unit
) {
    val movieDetail = viewModel.movieDetail.observeAsState(MovieDetail()).value
    val similarMovie = viewModel.similarMovie.observeAsState(listOf()).value

    LazyColumn(
        modifier = Modifier.background(Color.Black)
    ) {
        item {
            MoviesDetailTopImageView(movieBackDrop = movieDetail.backdropPath)
        }

        item {
            MoviesDetailInfoView(
                modifier = Modifier.padding(start = 15.dp, top = 15.dp, end = 15.dp, bottom = 0.dp),
                movieDetail = movieDetail
            )
        }

        item {
            MoviesDetailOverviewView(
                modifier = Modifier.padding(start = 15.dp, top = 40.dp),
                overview = movieDetail.overview
            )
        }

        item {
            SimilarMoviesView(
                similarMovies = similarMovie, onMovieItemClick = onSimilarMovieClick,
                modifier = Modifier.padding(start = 15.dp, top = 40.dp)
            )
        }
    }
}