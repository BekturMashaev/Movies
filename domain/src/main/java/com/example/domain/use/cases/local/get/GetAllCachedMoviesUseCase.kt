package com.example.domain.use.cases.local.get

import com.example.domain.models.movie.info.MovieInfoDomainModel
import kotlinx.coroutines.flow.Flow

interface GetAllCachedMoviesUseCase {
    operator fun invoke(): Flow<List<MovieInfoDomainModel>>
}