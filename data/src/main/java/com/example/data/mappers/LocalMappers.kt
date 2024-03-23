package com.example.data.mappers

import com.example.data.databases.local.MoviesCacheModel
import com.example.domain.models.movie.info.MovieInfoDomainModel


fun MovieInfoDomainModel.toCache() = MoviesCacheModel(
    id = id,
    posterPath = posterPath,
    overview = overview,
    releaseDate = releaseDate,
    title = title,
    backdropPath = backdropPath,
    popularity = popularity,
    voteCount = voteCount,
    video = video,
    originalTitle = originalTitle,
    originalLanguage = originalLanguage,
    voteAverage = voteAverage,
    status = status,
    budget = budget,
    runtime = runtime ?: 0,
    adult = adult,
    country = country.orEmpty(),
    genres = genres.orEmpty()
)

fun MoviesCacheModel.toDomain() = MovieInfoDomainModel(
    id = id,
    posterPath = posterPath,
    overview = overview,
    releaseDate = releaseDate,
    title = title,
    backdropPath = backdropPath,
    popularity = popularity,
    voteCount = voteCount,
    video = video,
    genres = genres,
    originalTitle = originalTitle,
    originalLanguage = originalLanguage,
    voteAverage = voteAverage,
    status = status,
    budget = budget,
    runtime = runtime,
    adult = adult,
    country = country
)