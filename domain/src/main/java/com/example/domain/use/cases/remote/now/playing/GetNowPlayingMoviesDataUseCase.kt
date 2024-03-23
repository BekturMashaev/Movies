package com.example.domain.use.cases.remote.now.playing

import com.example.domain.base.models.ResultStatus
import com.example.domain.models.movie.list.MoviesListResultDomainModel

interface GetNowPlayingMoviesDataUseCase {
    suspend operator fun invoke(page: Int): ResultStatus<MoviesListResultDomainModel>
}