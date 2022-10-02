package vn.gst.sun.moviestatistic.presenter.home.view

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
fun TopRatedMoviesView(
    modifier: Modifier = Modifier,
    topRatedMovies: List<Movie>
) {
    Column(modifier = modifier) {

        Text(
            text = stringResource(id = R.string.top_rated_movies_title),
            modifier = Modifier
                .padding(start = 20.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White
        )

        LazyRow(
            modifier = Modifier.padding(top = 10.dp),
            contentPadding = PaddingValues(horizontal = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            if (topRatedMovies.isNotEmpty()) {
                items(count = topRatedMovies.size, key = {
                    topRatedMovies[it].id
                }) {
                    val movie = topRatedMovies[it]
                    TopRatedMoviesItemView(movie = movie)
                }
            } else {
                items(count = 20) {
                    TopRatedMoviesItemLoadingView()
                }
            }
        }
    }
}