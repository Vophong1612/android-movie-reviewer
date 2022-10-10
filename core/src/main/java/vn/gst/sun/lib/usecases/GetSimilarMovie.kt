package vn.gst.sun.lib.usecases

import vn.gst.sun.lib.repositories.MovieRepository

class GetSimilarMovie(private val repository: MovieRepository) {
    operator fun invoke(movieId: Int) = repository.getSimilarMovies(movieId)
}