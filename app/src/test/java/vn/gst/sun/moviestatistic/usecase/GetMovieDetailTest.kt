package vn.gst.sun.moviestatistic.usecase

import android.annotation.SuppressLint
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import vn.gst.sun.lib.data.MovieDetail
import vn.gst.sun.lib.usecases.GetMovieDetailUseCase

class GetMovieDetailTest {

    private lateinit var SUT: GetMovieDetailUseCase //system under test
    private lateinit var repository: MovieRepositoryTestMock

    companion object {
        private const val MOVIE_ID = 123
    }

    @Before
    fun setUp() {
        repository = MovieRepositoryTestMock()
        SUT = GetMovieDetailUseCase(repository)
    }

    @Test
    @SuppressLint("CheckResult")
    fun invoke_success() {
        //
        //
        val flowable = SUT.invoke(MOVIE_ID)
        var data = MovieDetail()
        flowable.subscribe {
            data = it
        }
        Assert.assertEquals(MOVIE_ID, data.id)
    }

    @Test
    @SuppressLint("CheckResult")
    fun invoke_failure() {
        //
        repository.isFailure = true
        //
        val flowable = SUT.invoke(MOVIE_ID)
        var data = MovieDetail()
        flowable.subscribe {
            data = it
        }
        //
        Assert.assertNotEquals(MOVIE_ID, data.id)
    }
}