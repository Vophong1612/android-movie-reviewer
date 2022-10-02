package vn.gst.sun.lib.usecase

import vn.gst.sun.lib.repository.MovieRepository

class GetTopRatedMovies(private val repository: MovieRepository) {
    operator fun invoke() = repository.getTopRatedMovies()
}