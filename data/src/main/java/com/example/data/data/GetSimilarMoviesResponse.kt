package com.example.data.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetSimilarMoviesResponse (
    @SerializedName("page")
    @Expose
    val page: Int,

    @SerializedName("total_results")
    @Expose
    val totalMovies: Int,

    @SerializedName("total_pages")
    @Expose
    val totalPages: Int,

    @SerializedName("results")
    @Expose
    val movieReponses: List<MovieResponse>
)