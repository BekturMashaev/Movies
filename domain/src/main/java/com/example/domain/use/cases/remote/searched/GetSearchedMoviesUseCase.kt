package com.example.domain.use.cases.remote.searched

import com.example.domain.base.models.ResultStatus
import com.example.domain.models.movie.list.MoviesListResultDomainModel

interface GetSearchedMoviesUseCase {
    suspend operator fun invoke(query:String): ResultStatus<MoviesListResultDomainModel>
}