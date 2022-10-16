package vn.gst.sun.lib.usecases

import javax.inject.Inject
import vn.gst.sun.lib.repositories.MovieRepository

class GetPopularMoviesUseCase @Inject constructor (private val repository: MovieRepository) {
    operator fun invoke() = repository.getPopularMovies()
}