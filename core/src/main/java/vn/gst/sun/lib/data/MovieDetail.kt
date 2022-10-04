package vn.gst.sun.lib.data

class MovieDetail(
    val adult: Boolean = false,
    val backdropPath: String = "",
    val budget: Int = 0,
    val genres: List<Genres> = arrayListOf(),
    val homepage: String = "",
    val id: Int = 0,
    val imdbId: String = "",
    val originalLanguage: String = "",
    val originalTitle: String  = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val posterPath: String = "",
    val productionCompanies: List<ProductionCompanies> = arrayListOf(),
    val productionCountries: List<ProductionCountries> = arrayListOf(),
    val releaseDate: String = "1900-01-01",
    val revenue: Int = 0,
    val runtime: Int = 0,
    val spokenLanguages: List<SpokenLanguages> = arrayListOf(),
    val status: String = "",
    val tagline: String = "",
    val title: String = "Movie's name",
    val video: Boolean = false,
    val voteAverage: Double = 0.0,
    val voteCount: Int = 0
)