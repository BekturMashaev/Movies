package com.example.domain.use.cases.remote.top.rated

import com.example.domain.base.models.ResultStatus
import com.example.domain.models.movie.list.MoviesListResultDomainModel

interface GetTopRatedMoviesDataUseCase {
    suspend operator fun invoke(page: Int): ResultStatus<MoviesListResultDomainModel>
}