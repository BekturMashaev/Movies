package com.example.domain.use.cases.remote.top.rated

import com.example.domain.base.models.ResultStatus
import com.example.domain.models.movie.list.MoviesListResultDomainModel
import com.example.domain.repository.MovieRepository

class DefaultGetTopRatedMoviesDataUseCase(
    private val repository: MovieRepository
) : GetTopRatedMoviesDataUseCase {
    override suspend fun invoke(page: Int): ResultStatus<MoviesListResultDomainModel> {
        return repository.getTopRatedMovies(page = page)
    }
}