package vn.gst.sun.moviestatistic.framework.service.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import vn.gst.sun.lib.data.Movie

data class MovieResponse(
    @SerializedName("vote_count") @Expose
    private var voteCount: Int,
    @SerializedName("id")
    @Expose
    private val id: Int,

    @SerializedName("video")
    @Expose
    private val video: Boolean,

    @SerializedName("vote_average")
    @Expose
    private val voteAverage: Double,

    @SerializedName("title")
    @Expose
    private val title: String,

    @SerializedName("popularity")
    @Expose
    private val popularity: Double,

    @SerializedName("poster_path")
    @Expose
    private val posterPath: String,

    @SerializedName("original_language")
    @Expose
    private val originalLanguage: String,

    @SerializedName("original_title")
    @Expose
    private val originalTitle: String,

    @SerializedName("genre_ids")
    @Expose
    private val genreIds: List<Int> = ArrayList(),

    @SerializedName("backdrop_path")
    @Expose
    private val backdropPath: String,

    @SerializedName("adult")
    @Expose
    private val adult: Boolean,

    @SerializedName("overview")
    @Expose
    private val overview: String,

    @SerializedName("release_date")
    @Expose
    private val releaseDate: String
) {
    fun toMovie() = Movie(
        voteCount,
        id,
        video,
        voteAverage,
        title,
        popularity,
        posterPath,
        originalLanguage,
        originalTitle,
        genreIds,
        backdropPath,
        adult,
        overview,
        releaseDate
    )
}