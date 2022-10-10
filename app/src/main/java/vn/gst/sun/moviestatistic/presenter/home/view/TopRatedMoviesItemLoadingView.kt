package vn.gst.sun.moviestatistic.presenter.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import vn.gst.sun.moviestatistic.R

@Composable
fun TopRatedMoviesItemLoadingView(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.size(150.dp, 350.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .background(colorResource(id = R.color.grey_50))
        )

        Box(modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxWidth()
            .height(25.dp)
            .background(color = colorResource(id = R.color.grey_50), shape = RoundedCornerShape(5.dp)))

        Box(modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxWidth()
            .height(25.dp)
            .background(colorResource(id = R.color.grey_50), shape = RoundedCornerShape(5.dp)))
    }
}