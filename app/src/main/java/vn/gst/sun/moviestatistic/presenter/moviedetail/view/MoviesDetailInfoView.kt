package vn.gst.sun.moviestatistic.presenter.moviedetail.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
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
import vn.gst.sun.lib.data.MovieDetail
import vn.gst.sun.moviestatistic.Constants
import vn.gst.sun.moviestatistic.R

@Composable
fun MoviesDetailInfoView(
    modifier: Modifier = Modifier,
    movieDetail: MovieDetail
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(176.dp)
    ) {
        AsyncImage(
            model = Constants.ROOT_POSTER_PATH + movieDetail.posterPath,
            contentDescription = "",
            modifier = Modifier
                .width(120.dp)
                .fillMaxHeight(),
            contentScale = ContentScale.Crop,
            placeholder = rememberAsyncImagePainter(model = R.drawable.bg_image_placeholder_error),
            error = rememberAsyncImagePainter(model = R.drawable.bg_image_placeholder_error)
        )

        Box(
            modifier = Modifier
                .padding(start = 18.dp)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
            ) {
                Text(
                    text = stringResource(
                        id = R.string.movie_detail_name,
                        movieDetail.title,
                        DateUtils.getYear(movieDetail.releaseDate)
                    ),
                    modifier = Modifier.padding(end = 20.dp),
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                var category = ""
                movieDetail.genres.mapIndexed { index, genres ->
                    category += if (index != 0) ", ${genres.name}" else genres.name
                }
                Text(
                    text = category,
                    color = Color.White,
                    fontSize = 20.sp,
                    maxLines = 2,
                    modifier = Modifier.padding(top = 10.dp)
                )

            }

            val voteAverage = movieDetail.voteAverage.toFloat()

            Row(
                modifier = Modifier.align(Alignment.BottomStart)
            ) {
                RatingBar(
                    value = voteAverage * 0.5f,
                    config = RatingBarConfig()
                        .size(20.dp)
                        .style(RatingBarStyle.HighLighted),
                    onValueChange = {
                    },
                    onRatingChanged = {},
                    modifier = Modifier.padding(top = 3.dp)
                )

                Text(
                    text = String.format("%.1f", voteAverage) + "/10",
                    modifier = Modifier.padding(start = 15.dp),
                    color = colorResource(id = R.color.rating_active),
                    fontSize = 16.sp,
                )
            }
        }
    }
}