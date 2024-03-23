package com.example.data.mappers

import com.example.data.models.movie.info.MovieInfoDataModel
import com.example.data.models.movie.list.MovieResultDataModel
import com.example.data.models.movie.list.MoviesListResultDataModel
import com.example.data.utils.Constants.POSTER_PATH_URL
import com.example.domain.models.movie.info.MovieInfoDomainModel
import com.example.domain.models.movie.list.MovieResultDomainModel
import com.example.domain.models.movie.list.MoviesListResultDomainModel

fun MovieResultDataModel.toDomainModel() = MovieResultDomainModel(
    isForAdults = isForAdults,
    id = id,
    language = language,
    title = title,
    overview = overview,
    popularity = popularity,
    poster = POSTER_PATH_URL +poster,
    releaseDate = releaseDate,
    voteAverage = voteAverage,
    voteCount = voteCount
)

fun MoviesListResultDataModel.toDomainModel() = MoviesListResultDomainModel(
    results = results.map { it.toDomainModel() }
)

/** from data to domain (info)**/
fun MovieInfoDataModel.toDomain() = MovieInfoDomainModel(
    adult = adult,
    backdropPath = POSTER_PATH_URL +backdropPath,
    budget = budget,
    genres = genres?.map { it.name },
    id = id,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    releaseDate = releaseDate,
    runtime = runtime,
    status = status,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount,
    popularity = popularity,
    posterPath = POSTER_PATH_URL +posterPath,
    overview = overview,
    country = country?.map { it.name },
)