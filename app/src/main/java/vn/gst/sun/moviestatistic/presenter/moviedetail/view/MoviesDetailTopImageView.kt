package vn.gst.sun.moviestatistic.presenter.moviedetail.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.data.Constants
import vn.gst.sun.moviestatistic.R

@Composable
fun MoviesDetailTopImageView(
    modifier: Modifier = Modifier,
    movieBackDrop: String?
) {
    Box(
        modifier = modifier
            .requiredHeight(300.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = Constants.ROOT_POSTER_PATH + movieBackDrop,
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
                            colorResource(id = R.color.black_50),
                            colorResource(id = R.color.black),
                        )
                    )
                )
        )
    }
}