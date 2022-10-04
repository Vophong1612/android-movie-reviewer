package vn.gst.sun.lib.usecase

import vn.gst.sun.lib.repository.MovieRepository

class GetSimilarMovie(private val repository: MovieRepository) {
    operator fun invoke(movieId: Int) = repository.getSimilarMovies(movieId)
}