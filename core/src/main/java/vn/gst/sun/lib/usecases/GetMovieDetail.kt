package vn.gst.sun.lib.usecases

import vn.gst.sun.lib.repositories.MovieRepository

class GetMovieDetail(private val repository: MovieRepository) {
    operator fun invoke(movieId: Int) = repository.getMovieDetail(movieId)
}