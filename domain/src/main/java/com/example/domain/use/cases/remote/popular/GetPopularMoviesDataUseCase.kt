package com.example.domain.use.cases.remote.popular

import com.example.domain.base.models.ResultStatus
import com.example.domain.models.movie.list.MoviesListResultDomainModel

interface GetPopularMoviesDataUseCase {
    suspend operator fun invoke(page: Int): ResultStatus<MoviesListResultDomainModel>
}