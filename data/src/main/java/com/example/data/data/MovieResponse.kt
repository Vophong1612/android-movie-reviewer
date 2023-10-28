package com.example.data.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("vote_count") @Expose
    var voteCount: Int,
    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("video")
    @Expose
    val video: Boolean,

    @SerializedName("vote_average")
    @Expose
    val voteAverage: Double,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("popularity")
    @Expose
    val popularity: Double,

    @SerializedName("poster_path")
    @Expose
    val posterPath: String,

    @SerializedName("original_language")
    @Expose
    val originalLanguage: String,

    @SerializedName("original_title")
    @Expose
    val originalTitle: String,

    @SerializedName("genre_ids")
    @Expose
    val genreIds: List<Int> = ArrayList(),

    @SerializedName("backdrop_path")
    @Expose
    val backdropPath: String?,

    @SerializedName("adult")
    @Expose
    val adult: Boolean,

    @SerializedName("overview")
    @Expose
    val overview: String,

    @SerializedName("release_date")
    @Expose
    val releaseDate: String
)