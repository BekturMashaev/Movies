package com.example.domain.models.movie.info


data class MovieInfoDomainModel(
    val id: Int,
    val adult: Boolean?,
    val backdropPath: String?,
    val budget: Int?,
    val genres: List<String>?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    val posterPath: String?,
    val releaseDate: String?,
    val runtime: Int?,
    val status: String?,
    val title: String?,
    val video: Boolean?,
    val voteAverage: Double?,
    val voteCount: Int?,
    val country:List<String>?
)