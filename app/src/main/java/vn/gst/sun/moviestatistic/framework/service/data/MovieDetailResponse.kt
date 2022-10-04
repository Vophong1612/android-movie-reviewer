package vn.gst.sun.moviestatistic.framework.service.data

import com.google.gson.annotations.SerializedName
import vn.gst.sun.lib.data.MovieDetail

data class MovieDetailResponse(
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("budget") val budget: Int,
    @SerializedName("genres") val genres: ArrayList<Genres>,
    @SerializedName("homepage") val homepage: String?,
    @SerializedName("id") val id: Int,
    @SerializedName("imdb_id") val imdbId: String?,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview") val overview: String?,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("production_companies") val productionCompanies: ArrayList<ProductionCompanies>,
    @SerializedName("production_countries") val productionCountries: ArrayList<ProductionCountries>,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("revenue") val revenue: Int,
    @SerializedName("runtime") val runtime: Int?,
    @SerializedName("spoken_languages") val spokenLanguages: ArrayList<SpokenLanguages>,
    @SerializedName("status") val status: String,
    @SerializedName("tagline") val tagline: String?,
    @SerializedName("title") val title: String,
    @SerializedName("video") val video: Boolean,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Int
) {
    fun toMovieDetail() = MovieDetail(
        adult,
        backdropPath?:"",
        budget,
        genres.map { it.toGenres() },
        homepage?:"",
        id,
        imdbId?:"",
        originalLanguage,
        originalTitle,
        overview?:"",
        popularity,
        posterPath?:"",
        productionCompanies.map { it.toProductionCompanies() },
        productionCountries.map { it.toProductionCountries() },
        releaseDate,
        revenue,
        runtime?:0,
        spokenLanguages.map { it.toSpokenLanguages() },
        status,
        tagline?:"", title, video, voteAverage, voteCount
    )
}

data class Genres(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
) {
    fun toGenres() = vn.gst.sun.lib.data.Genres(id, name)
}

data class ProductionCompanies(
    @SerializedName("id") val id: Int,
    @SerializedName("logo_path") val logoPath: String?,
    @SerializedName("name") val name: String,
    @SerializedName("origin_country") val originCountry: String
) {
    fun toProductionCompanies() = vn.gst.sun.lib.data.ProductionCompanies(id, logoPath?:"", name, originCountry)
}

data class ProductionCountries(
    @SerializedName("iso_3166_1") val iso31661: String,
    @SerializedName("name") val name: String
) {
    fun toProductionCountries() = vn.gst.sun.lib.data.ProductionCountries(iso31661, name)
}

data class SpokenLanguages(
    @SerializedName("iso_639_1") val iso6391: String,
    @SerializedName("name") val name: String
) {
    fun toSpokenLanguages() = vn.gst.sun.lib.data.SpokenLanguages(iso6391, name)
}