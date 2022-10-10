package vn.gst.sun.lib.usecases

import vn.gst.sun.lib.repositories.MovieRepository

class GetPopularMovies(private val repository: MovieRepository) {
    operator fun invoke() = repository.getPopularMovies()
}