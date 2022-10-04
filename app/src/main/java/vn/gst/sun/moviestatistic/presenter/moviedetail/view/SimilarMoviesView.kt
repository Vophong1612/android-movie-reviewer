package vn.gst.sun.moviestatistic.presenter.moviedetail.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vn.gst.sun.lib.data.Movie
import vn.gst.sun.moviestatistic.R

@Composable
fun SimilarMoviesView(
    modifier: Modifier = Modifier,
    similarMovies: List<Movie>,
    onMovieItemClick: (movieId: Int) -> Unit
) {
    Column(modifier = modifier) {

        Text(
            text = stringResource(id = R.string.similar_movies_title),
            modifier = Modifier,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White
        )

        LazyRow(
            modifier = Modifier.padding(top = 15.dp),
            contentPadding = PaddingValues(horizontal = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            if (similarMovies.isNotEmpty()) {
                items(count = similarMovies.size, key = {
                    similarMovies[it].id
                }) {
                    val movie = similarMovies[it]
                    SimilarMoviesItemView(
                        movie = movie,
                        onMovieItemClick = onMovieItemClick
                    )
                }
            } else {
                items(count = 20) {
                    SimilarMoviesItemLoadingView()
                }
            }
        }
    }
}