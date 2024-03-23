package com.example.domain.use.cases.local.get

import com.example.domain.models.movie.info.MovieInfoDomainModel
import com.example.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetAllCachedMoviesUseCaseImpl(
    private val movieRepository: MovieRepository
) : GetAllCachedMoviesUseCase {
    override fun invoke(): Flow<List<MovieInfoDomainModel>> {
        return movieRepository.getAllCachedMovies()
    }
}