package vn.gst.sun.moviestatistic.usecase

import io.reactivex.Flowable
import vn.gst.sun.lib.data.Movie
import vn.gst.sun.lib.data.MovieDetail
import vn.gst.sun.lib.repositories.MovieRepository

class MovieRepositoryTestMock : MovieRepository {

    var isFailure: Boolean = false

    override fun getPopularMovies(limit: Int): Flowable<List<Movie>> {
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

    override fun getTopRatedMovies(limit: Int): Flowable<List<Movie>> {
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

    override fun getMovieDetail(movieId: Int): Flowable<MovieDetail> {
        return if (!isFailure) {
            Flowable.just(
                MovieDetail(id = 123)
            )
        } else {
            Flowable.just(MovieDetail())
        }
    }

    override fun getSimilarMovies(movieId: Int, limit: Int): Flowable<List<Movie>> {
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