package vn.gst.sun.moviestatistic.presenter.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import vn.gst.sun.lib.data.Movie
import vn.gst.sun.moviestatistic.Constants
import vn.gst.sun.moviestatistic.R

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PopularMoviesView(
    modifier: Modifier = Modifier,
    popularMovies: List<Movie>,
    onMovieItemClick: (movieId: Int) -> Unit
) {
    Box(modifier = modifier) {
        if (popularMovies.isNotEmpty()) {
            HorizontalPager(
                count = popularMovies.size,
                state = rememberPagerState(initialPage = 0),
                modifier = Modifier.fillMaxWidth(),
                key = { popularMovies[it].id }
            ) { page ->
                val movie = popularMovies[page]
                PopularMovieViewItem(
                    movie = movie,
                    onMovieItemClick = onMovieItemClick
                )
            }
        } else {
            PopuplarMoviesLoadingView()
        }

        Box(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            colorResource(id = R.color.black_50),
                            colorResource(id = R.color.transparent),
                        )
                    )
                )
        )

        Text(
            text = stringResource(id = R.string.popular_movies_title),
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 20.dp, top = 10.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White
        )
    }
}