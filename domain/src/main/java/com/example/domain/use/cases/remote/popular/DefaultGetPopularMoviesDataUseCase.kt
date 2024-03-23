package com.example.domain.use.cases.remote.popular

import com.example.domain.base.models.ResultStatus
import com.example.domain.models.movie.list.MoviesListResultDomainModel
import com.example.domain.repository.MovieRepository

class DefaultGetPopularMoviesDataUseCase(
    private val repository: MovieRepository
) : GetPopularMoviesDataUseCase {
    override suspend fun invoke(page: Int): ResultStatus<MoviesListResultDomainModel> {
        return repository.getPopularMovies(page = page)
    }
}