package com.example.data.repositories

import com.example.data.mapper.toMovie
import com.example.data.mapper.toMovieDetail
import com.example.data.service.service.MovieDataService
import io.reactivex.Flowable
import javax.inject.Inject
import vn.gst.sun.lib.data.Movie
import vn.gst.sun.lib.data.MovieDetail
import vn.gst.sun.lib.repositories.MovieRepository

class MovieRepositoryImpl @Inject constructor(
    private val movieDataService: MovieDataService
) : MovieRepository {

    override fun getPopularMovies(limit: Int): Flowable<List<Movie>> {
        val popularMoviesResponse = movieDataService.getPopularMovies()
        return popularMoviesResponse.map {
            if (it.movieReponses.size > limit) {
                it.movieReponses.subList(0, limit).map { movieRes ->
                    movieRes.toMovie()
                }
            } else {
                it.movieReponses.map { movieRes ->
                    movieRes.toMovie()
                }
            }
        }
    }

    override fun getTopRatedMovies(limit: Int): Flowable<List<Movie>> {
        val topRatedMoviesResponse = movieDataService.getTopRatedMovies()
        return topRatedMoviesResponse.map {
            if (it.movieReponses.size > limit) {
                it.movieReponses.subList(0, limit).map { movieRes ->
                    movieRes.toMovie()
                }
            } else {
                it.movieReponses.map { movieRes ->
                    movieRes.toMovie()
                }
            }
        }
    }

    override fun getMovieDetail(movieId: Int): Flowable<MovieDetail> {
        val movieResponse = movieDataService.getMovieDetail(movieId)
        return movieResponse.map { it.toMovieDetail() }
    }

    override fun getSimilarMovies(movieId: Int, limit: Int): Flowable<List<Movie>> {
        val similarMoviesResponse = movieDataService.getSimilarMovie(movieId)
        return similarMoviesResponse.map {
            if (it.movieReponses.size > limit) {
                it.movieReponses.subList(0, limit).map {movieRes ->
                    movieRes.toMovie()
                }
            } else {
                it.movieReponses.map {movieRes ->
                    movieRes.toMovie()
                }
            }
        }
    }
}