package vn.gst.sun.moviestatistic.usecase

import android.annotation.SuppressLint
import io.reactivex.Flowable
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import vn.gst.sun.lib.data.Movie
import vn.gst.sun.lib.repository.MovieRepository
import vn.gst.sun.lib.usecase.GetPopularMovies

class GetPopularMoviesTest {

    private lateinit var SUT: GetPopularMovies
    private lateinit var repository: MovieRepositoryTestMock

    @Before
    fun setUp() {
        repository = MovieRepositoryTestMock()
        SUT = GetPopularMovies(repository)
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

    class MovieRepositoryTestMock : MovieRepository {

        var isFailure: Boolean = false

        override fun getPopularMovies(): Flowable<List<Movie>> {
            return if (!isFailure) {
                Flowable.just(
                    arrayListOf(
                        Movie(
                            0, 0, false, 0.0, "", 0.0, "",
                            "", "", arrayListOf(), "", false, "", ""
                        ),
                        Movie(
                            0, 0, false, 0.0, "", 0.0, "",
                            "", "", arrayListOf(), "", false, "", ""
                        )
                    )
                )
            } else {
                Flowable.just(arrayListOf())
            }
        }
    }
}