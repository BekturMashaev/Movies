package com.example.domain.use.cases.local.save

import com.example.domain.models.movie.info.MovieInfoDomainModel
import com.example.domain.repository.MovieRepository

class SaveMovieToCacheUseCaseImpl(
    private val movieRepository: MovieRepository
) : SaveMovieToCacheUseCase {
    override suspend fun invoke(movieDomainModel: MovieInfoDomainModel) {
        movieRepository.saveMovieToCache(movieDomainModel)
    }
}