package com.example.domain.use.cases.remote.info

import com.example.domain.base.models.ResultStatus
import com.example.domain.models.movie.info.MovieInfoDomainModel


interface GetMovieInfoUseCase {
    suspend operator fun invoke(movieId: Int): ResultStatus<MovieInfoDomainModel>
}