package vn.gst.sun.lib.data

data class Movie(
    private var voteCount: Int,
    private val id: Int,
    private val video: Boolean,
    private val voteAverage: Double,
    private val title: String,
    private val popularity: Double,
    private val posterPath: String,
    private val originalLanguage: String,
    private val originalTitle: String,
    private val genreIds: List<Int> = ArrayList(),
    private val backdropPath: String,
    private val adult: Boolean,
    private val overview: String,
    private val releaseDate: String
)