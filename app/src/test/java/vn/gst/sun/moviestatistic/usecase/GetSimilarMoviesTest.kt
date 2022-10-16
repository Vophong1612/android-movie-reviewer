package vn.gst.sun.moviestatistic.usecase

import android.annotation.SuppressLint
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import vn.gst.sun.lib.data.Movie
import vn.gst.sun.lib.usecases.GetSimilarMovieUseCase

class GetSimilarMoviesTest {

    private lateinit var SUT: GetSimilarMovieUseCase
    private lateinit var repository: MovieRepositoryTestMock

    companion object {
        private const val MOVIE_ID = 123
    }

    @Before
    fun setUp() {
        repository = MovieRepositoryTestMock()
        SUT = GetSimilarMovieUseCase(repository)
    }

    @Test
    @SuppressLint("CheckResult")
    fun invoke_success() {
        //
        //
        val flowable = SUT.invoke(MOVIE_ID)
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
        val flowable = SUT.invoke(MOVIE_ID)
        var data: List<Movie> = arrayListOf()
        flowable.subscribe {
            data = it
        }
        //
        Assert.assertTrue(data.isEmpty())
    }
}