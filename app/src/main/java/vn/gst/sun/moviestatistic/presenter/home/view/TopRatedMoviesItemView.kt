package vn.gst.sun.moviestatistic.presenter.home.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import vn.gst.sun.lib.DateUtils
import vn.gst.sun.lib.data.Movie
import com.example.data.Constants
import vn.gst.sun.moviestatistic.R

@Composable
fun TopRatedMoviesItemView(
    modifier: Modifier = Modifier,
    movie: Movie,
    onMovieItemClick: (movieId: Int) -> Unit
) {
    Column(
        modifier = modifier
            .size(150.dp, 350.dp)
            .clickable {
                onMovieItemClick.invoke(movie.id)
            }
    ) {
        AsyncImage(
            model = Constants.ROOT_POSTER_PATH + movie.posterPath,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            placeholder = rememberAsyncImagePainter(model = R.drawable.bg_image_placeholder_error),
            error = rememberAsyncImagePainter(model = R.drawable.bg_image_placeholder_error)
        )

        Text(
            text = movie.title,
            textAlign = TextAlign.Start,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 5.dp)
        )

        Text(
            text = DateUtils.formatToDDMMMYYYY(movie.releaseDate),
            textAlign = TextAlign.Start,
            color = Color.White,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 5.dp)
        )
    }
}