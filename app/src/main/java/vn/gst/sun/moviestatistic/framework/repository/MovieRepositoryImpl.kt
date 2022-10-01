package vn.gst.sun.moviestatistic.framework.repository

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import vn.gst.sun.lib.data.Movie
import vn.gst.sun.lib.repository.MovieRepository
import vn.gst.sun.moviestatistic.framework.service.service.MovieDataService

class MovieRepositoryImpl(
    private val movieDataService: MovieDataService
) : MovieRepository {

    override fun getPopularMovies(): Flowable<List<Movie>> {
        val popularMoviesResponse = movieDataService.getPopularMovies()
        return popularMoviesResponse.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.movieReponses.map { movieRes -> movieRes.toMovie() } }
    }

    /*override fun getMovieDetail(movieId: Int): Movie? {

    }*/
}