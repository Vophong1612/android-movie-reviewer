package vn.gst.sun.moviestatistic.framework.repository

import android.annotation.SuppressLint
import io.reactivex.Flowable
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import vn.gst.sun.lib.data.Movie
import vn.gst.sun.lib.data.MovieDetail
import vn.gst.sun.moviestatistic.framework.service.data.GetPopularMoviesResponse
import vn.gst.sun.moviestatistic.framework.service.data.GetSimilarMoviesResponse
import vn.gst.sun.moviestatistic.framework.service.data.GetTopRatedMoviesResponse
import vn.gst.sun.moviestatistic.framework.service.data.MovieDetailResponse
import vn.gst.sun.moviestatistic.framework.service.data.MovieResponse
import vn.gst.sun.moviestatistic.framework.service.service.MovieDataService

@SuppressLint("CheckResult")
class MovieRepositoryImplTest {

    private lateinit var SUT: MovieRepositoryImpl
    private lateinit var movieDataServiceMock: MovieDataServiceMock

    @Before
    fun beforeAll() {
        movieDataServiceMock = MovieDataServiceMock()
        SUT = MovieRepositoryImpl(movieDataServiceMock)
    }

    @Test
    fun getPopularMovies_onSuccess() {
        //
        movieDataServiceMock.isSuccess = true
        //
        val response = SUT.getPopularMovies()
        var movies = listOf<Movie>()
        response.subscribe( {
            movies = it
        }, {})
        //
        assertTrue(movies.isNotEmpty())
    }

    @Test
    fun getPopularMovies_onFail() {
        //
        movieDataServiceMock.isSuccess = false
        //
        val response = SUT.getPopularMovies()
        var movies = listOf<Movie>()
        response.subscribe({
            movies = it
        }, {})
        //
        assertTrue(movies.isEmpty())
    }

    @Test
    fun getTopRatedMovies_onSuccess() {
        //
        movieDataServiceMock.isSuccess = true
        //
        val response = SUT.getPopularMovies()
        var movies = listOf<Movie>()
        response.subscribe( {
            movies = it
        }, {})
        //
        assertTrue(movies.isNotEmpty())
    }

    @Test
    fun getTopRatedMovies_onFail() {
        //
        movieDataServiceMock.isSuccess = false
        //
        val response = SUT.getTopRatedMovies()
        var movies = listOf<Movie>()
        response.subscribe({
            movies = it
        }, {})
        //
        assertTrue(movies.isEmpty())
    }

    @Test
    fun getSimilarMovies_onSuccess() {
        //
        movieDataServiceMock.isSuccess = true
        //
        val response = SUT.getSimilarMovies(123)
        var movies = listOf<Movie>()
        response.subscribe( {
            movies = it
        }, {})
        //
        assertTrue(movies.isNotEmpty())
    }

    @Test
    fun getSimilarMovies_onFail() {
        //
        movieDataServiceMock.isSuccess = false
        //
        val response = SUT.getSimilarMovies(123)
        var movies = listOf<Movie>()
        response.subscribe({
            movies = it
        }, {})
        //
        assertTrue(movies.isEmpty())
    }

    @Test
    fun getMovieDetail_onSuccess() {
        //
        movieDataServiceMock.isSuccess = true
        //
        val response = SUT.getMovieDetail(123)
        var movie = MovieDetail()
        response.subscribe( {
             movie = it               
        }, {})
        //
        assertEquals(123, movie.id)
    }

    @Test
    fun getMovieDetail_onFail() {
        //
        movieDataServiceMock.isSuccess = false
        //
        val response = SUT.getMovieDetail(123)
        var movie = MovieDetail()
        response.subscribe( {
            movie = it
        }, {})
        //
        assertEquals(-1, movie.id)
    }

    class MovieDataServiceMock : MovieDataService {

        var isSuccess = true

        override fun getPopularMovies(): Flowable<GetPopularMoviesResponse> {
            return if (isSuccess) {
                Flowable.just(GetPopularMoviesResponse(1, 20, 10,
                    listOf(
                        MovieResponse(0, 1, false, 0.0, "", 0.0, "","","", listOf(), "", false, "", ""),
                        MovieResponse(0, 2, false, 0.0, "", 0.0, "","","", listOf(), "", false, "", "")
                    ))
                )
            } else {
                Flowable.just(GetPopularMoviesResponse(0,0,0, listOf()))
            }
        }

        override fun getTopRatedMovies(): Flowable<GetTopRatedMoviesResponse> {
            return if (isSuccess) {
                Flowable.just(GetTopRatedMoviesResponse(1, 20, 10,
                    listOf(
                        MovieResponse(0, 1, false, 0.0, "", 0.0, "","","", listOf(), "", false, "", ""),
                        MovieResponse(0, 2, false, 0.0, "", 0.0, "","","", listOf(), "", false, "", "")
                    ))
                )
            } else {
                Flowable.just(GetTopRatedMoviesResponse(0,0,0, listOf()))
            }
        }

        override fun getMovieDetail(movieId: Int): Flowable<MovieDetailResponse> {
            return if (isSuccess) {
                Flowable.just(MovieDetailResponse(false, "",0, arrayListOf() ,"", 123,"", "", "", "", 0.0, "", arrayListOf(), arrayListOf(), "", 0,0, arrayListOf(), "", "","", false, 0.0, 0))
            } else {
                Flowable.just(MovieDetailResponse(false, "",0, arrayListOf() ,"", -1,"", "", "", "", 0.0, "", arrayListOf(), arrayListOf(), "", 0,0, arrayListOf(), "", "","", false, 0.0, 0))
            }
        }

        override fun getSimilarMovie(movieId: Int): Flowable<GetSimilarMoviesResponse> {
            return if (isSuccess) {
                Flowable.just(GetSimilarMoviesResponse(1, 20, 10,
                    listOf(
                        MovieResponse(0, 1, false, 0.0, "", 0.0, "","","", listOf(), "", false, "", ""),
                        MovieResponse(0, 2, false, 0.0, "", 0.0, "","","", listOf(), "", false, "", "")
                    ))
                )
            } else {
                Flowable.just(GetSimilarMoviesResponse(0,0,0, listOf()))
            }
        }

    }
}