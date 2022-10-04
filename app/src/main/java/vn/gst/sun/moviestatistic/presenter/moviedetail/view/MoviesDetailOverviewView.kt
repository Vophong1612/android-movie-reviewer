package vn.gst.sun.moviestatistic.presenter.moviedetail.view

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vn.gst.sun.moviestatistic.R

@Composable
fun MoviesDetailOverviewView(
    modifier: Modifier = Modifier,
    overview: String
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.movie_detail_overview_title),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        var showMore by remember { mutableStateOf(false) }

        /*// Creating a long text
        val overview =
            "A computer science portal for geeks. It contains well written, well thought and well explained computer science and programming articles, quizzes and practice/competitive programming/company interview Questions." +
            "A computer science portal for geeks. It contains well written, well thought and well explained computer science and programming articles, quizzes and practice/competitive programming/company interview Questions." +
            "A computer science portal for geeks. It contains well written, well thought and well explained computer science and programming articles, quizzes and practice/competitive programming/company interview Questions." +
            "A computer science portal for geeks. It contains well written, well thought and well explained computer science and programming articles, quizzes and practice/competitive programming/company interview Questions." +
            "A computer science portal for geIt contains well written, well thought and well explained computer science and programming articles, quizzes and practice/competitive programming/company interview Questions."*/

        Column(modifier = Modifier
            .padding(top = 15.dp)
            .animateContentSize(animationSpec = tween(100))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { showMore = !showMore }
        ) {

            if (showMore) {
                Text(
                    text = overview,
                    color = Color.White,
                    fontSize = 18.sp
                )
            } else {
                Text(
                    text = overview,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        }
    }
}