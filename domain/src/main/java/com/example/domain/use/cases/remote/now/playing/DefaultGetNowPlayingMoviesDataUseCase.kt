package com.example.domain.use.cases.remote.now.playing

import com.example.domain.base.models.ResultStatus
import com.example.domain.models.movie.list.MoviesListResultDomainModel
import com.example.domain.repository.MovieRepository

class DefaultGetNowPlayingMoviesDataUseCase(
    private val repository: MovieRepository
) : GetNowPlayingMoviesDataUseCase {
    override suspend fun invoke(page: Int): ResultStatus<MoviesListResultDomainModel> {
        return repository.getNowPlayingMovies(page = page)
    }
}