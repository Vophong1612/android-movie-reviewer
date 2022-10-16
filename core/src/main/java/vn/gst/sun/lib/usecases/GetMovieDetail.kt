package vn.gst.sun.lib.usecases

import javax.inject.Inject
import vn.gst.sun.lib.repositories.MovieRepository

class GetMovieDetail @Inject constructor (private val repository: MovieRepository) {
    operator fun invoke(movieId: Int) = repository.getMovieDetail(movieId)
}