package com.example.domain.use.cases.remote.upcoming

import com.example.domain.base.models.ResultStatus
import com.example.domain.models.movie.list.MoviesListResultDomainModel
import com.example.domain.repository.MovieRepository

class DefaultGetUpcomingMoviesDataUseCase(
    private val repository: MovieRepository
) : GetUpcomingMoviesDataUseCase {
    override suspend fun invoke(page: Int): ResultStatus<MoviesListResultDomainModel> {
        return repository.getUpcomingMovies(page = page)
    }
}