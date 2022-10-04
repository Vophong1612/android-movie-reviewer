package vn.gst.sun.moviestatistic.presenter.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle
import vn.gst.sun.lib.DateUtils
import vn.gst.sun.lib.data.Movie
import vn.gst.sun.moviestatistic.Constants
import vn.gst.sun.moviestatistic.R

@Composable
fun PopularMovieViewItem(
    modifier: Modifier = Modifier,
    movie: Movie,
    onMovieItemClick: (movieId: Int) -> Unit
) {
    var rating: Float by remember { mutableStateOf(movie.voteAverage.toFloat() * 0.5f) }

    Box(
        modifier = modifier
            .requiredHeight(600.dp)
            .fillMaxWidth()
            .clickable {
                onMovieItemClick.invoke(movie.id)
            }
    ) {
        AsyncImage(
            model = Constants.ROOT_POSTER_PATH + movie.posterPath,
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            placeholder = rememberAsyncImagePainter(model = R.drawable.bg_image_placeholder_error),
            error = rememberAsyncImagePainter(model = R.drawable.bg_image_placeholder_error)
        )
        Box(
            modifier = Modifier
                .fillMaxHeight(fraction = 0.5f)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            colorResource(id = R.color.transparent),
                            colorResource(id = R.color.coffee_1_50),
                            colorResource(id = R.color.coffee_1),
                        )
                    )
                )
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 20.dp, bottom = 20.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = movie.title,
                modifier = Modifier.padding(end = 20.dp),
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = DateUtils.formatToDDMMMYYYY(movie.releaseDate),
                modifier = Modifier.padding(top = 8.dp),
                color = Color.White,
                fontSize = 18.sp,
            )

            Row(
                modifier = Modifier.padding(top = 10.dp)
            ) {
                RatingBar(
                    value = rating,
                    config = RatingBarConfig()
                        .style(RatingBarStyle.HighLighted),
                    onValueChange = {
                    },
                    onRatingChanged = {}
                )

                Text(
                    text = stringResource(id = R.string.popular_movies_imdb, movie.voteAverage),
                    modifier = Modifier.padding(start = 15.dp),
                    color = Color.White,
                    fontSize = 18.sp,
                )
            }
        }
    }
}