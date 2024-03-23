package com.example.moviesapp.presentation.mappers

import com.example.domain.models.movie.info.MovieInfoDomainModel
import com.example.domain.models.movie.list.MovieResultDomainModel
import com.example.moviesapp.presentation.models.movie.info.MovieInfoDataModelUI
import com.example.moviesapp.presentation.models.movie.list.MovieResultUIModel

/** movieInfoModel **/
fun MovieInfoDomainModel.toUI() = MovieInfoDataModelUI(
    adult = adult,
    backdropPath = backdropPath,
    budget = budget,
    genres = genres,
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
    posterPath = posterPath,
    overview = overview,
    country = country,
)

/** resultModel **/

fun MovieResultDomainModel.toUIModel() = MovieResultUIModel(
    isForAdults = isForAdults,
    id = id,
    language = language,
    title = title,
    overview = overview,
    popularity = popularity,
    poster = poster,
    releaseDate = releaseDate,
    voteAverage = voteAverage,
    voteCount = voteCount
)


/** from ui to domain **/

fun MovieInfoDataModelUI.toDomain() = MovieInfoDomainModel(
    adult = adult,
    backdropPath = backdropPath,
    budget = budget,
    genres = genres,
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
    posterPath = posterPath,
    overview = overview,
    country = country,
)