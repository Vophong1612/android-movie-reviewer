package vn.gst.sun.moviestatistic.presenter.home.view

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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import vn.gst.sun.moviestatistic.R

@Composable
fun PopuplarMoviesLoadingView(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .requiredHeight(600.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.grey_50))
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
    }
}