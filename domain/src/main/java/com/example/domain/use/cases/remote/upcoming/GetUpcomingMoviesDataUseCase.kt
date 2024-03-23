package com.example.domain.use.cases.remote.upcoming

import com.example.domain.base.models.ResultStatus
import com.example.domain.models.movie.list.MoviesListResultDomainModel

interface GetUpcomingMoviesDataUseCase {
    suspend operator fun invoke(page: Int): ResultStatus<MoviesListResultDomainModel>
}