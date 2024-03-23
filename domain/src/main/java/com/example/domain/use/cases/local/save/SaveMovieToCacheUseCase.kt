package com.example.domain.use.cases.local.save

import com.example.domain.models.movie.info.MovieInfoDomainModel

interface SaveMovieToCacheUseCase {
    suspend operator fun invoke(movieDomainModel: MovieInfoDomainModel)
}