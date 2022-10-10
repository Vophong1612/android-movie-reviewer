package com.example.data.mapper

import com.example.data.data.Genres
import com.example.data.data.MovieDetailResponse
import com.example.data.data.MovieResponse
import com.example.data.data.ProductionCompanies
import com.example.data.data.ProductionCountries
import com.example.data.data.SpokenLanguages
import vn.gst.sun.lib.data.Movie
import vn.gst.sun.lib.data.MovieDetail

fun MovieResponse.toMovie() = Movie(
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

fun MovieDetailResponse.toMovieDetail() = MovieDetail(
    adult,
    backdropPath ?: "",
    budget,
    genres.map { it.toGenres() },
    homepage ?: "",
    id,
    imdbId ?: "",
    originalLanguage,
    originalTitle,
    overview ?: "",
    popularity,
    posterPath ?: "",
    productionCompanies.map { it.toProductionCompanies() },
    productionCountries.map { it.toProductionCountries() },
    releaseDate,
    revenue,
    runtime ?: 0,
    spokenLanguages.map { it.toSpokenLanguages() },
    status,
    tagline ?: "", title, video, voteAverage, voteCount
)

fun Genres.toGenres() = vn.gst.sun.lib.data.Genres(id, name)

fun ProductionCompanies.toProductionCompanies() =
    vn.gst.sun.lib.data.ProductionCompanies(id, logoPath ?: "", name, originCountry)

fun ProductionCountries.toProductionCountries() =
    vn.gst.sun.lib.data.ProductionCountries(iso31661, name)

fun SpokenLanguages.toSpokenLanguages() = vn.gst.sun.lib.data.SpokenLanguages(iso6391, name)


