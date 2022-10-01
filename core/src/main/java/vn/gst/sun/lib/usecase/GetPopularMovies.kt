package vn.gst.sun.lib.usecase

import vn.gst.sun.lib.repository.MovieRepository

class GetPopularMovies(private val repository: MovieRepository) {
    operator fun invoke() = repository.getPopularMovies()
}