package vn.gst.sun.moviestatistic.usecase

import android.annotation.SuppressLint
import io.reactivex.Flowable
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import vn.gst.sun.lib.data.Movie
import vn.gst.sun.lib.data.MovieDetail
import vn.gst.sun.lib.repository.MovieRepository
import vn.gst.sun.lib.usecase.GetPopularMovies
import vn.gst.sun.lib.usecase.GetTopRatedMovies

class GetTopRatedMoviesTest {

    private lateinit var SUT: GetTopRatedMovies
    private lateinit var repository: MovieRepositoryTestMock

    @Before
    fun setUp() {
        repository = MovieRepositoryTestMock()
        SUT = GetTopRatedMovies(repository)
    }

    @Test
    @SuppressLint("CheckResult")
    fun invoke_success() {
        //
        //
        val flowable = SUT.invoke()
        var data: List<Movie> = arrayListOf<Movie>()
        flowable.subscribe {
            data = it
        }
        Assert.assertTrue(data.isNotEmpty())
    }

    @Test
    @SuppressLint("CheckResult")
    fun invoke_failure() {
        //
        repository.isFailure = true
        //
        val flowable = SUT.invoke()
        var data: List<Movie> = arrayListOf()
        flowable.subscribe {
            data = it
        }
        //
        Assert.assertTrue(data.isEmpty())
    }
}