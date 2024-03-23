package com.example.domain.use.cases.remote.searched

import com.example.domain.base.models.ResultStatus
import com.example.domain.models.movie.list.MoviesListResultDomainModel
import com.example.domain.repository.MovieRepository

class DefaultGetSearchedMoviesUseCase(
    private val repository: MovieRepository
) : GetSearchedMoviesUseCase {
    override suspend fun invoke(query: String): ResultStatus<MoviesListResultDomainModel> {
        return repository.getSearchedMovies(query = query)
    }
}