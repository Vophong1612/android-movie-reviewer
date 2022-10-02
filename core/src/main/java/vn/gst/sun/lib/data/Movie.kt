package vn.gst.sun.lib.data

data class Movie(
    var voteCount: Int,
    val id: Int,
    val video: Boolean,
    val voteAverage: Double,
    val title: String,
    val popularity: Double,
    val posterPath: String,
    val originalLanguage: String,
    val originalTitle: String,
    val genreIds: List<Int> = ArrayList(),
    val backdropPath: String,
    val adult: Boolean,
    val overview: String,
    val releaseDate: String
)