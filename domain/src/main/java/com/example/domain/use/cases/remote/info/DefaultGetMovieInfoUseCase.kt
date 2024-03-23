package com.example.domain.use.cases.remote.info

import com.example.domain.base.models.ResultStatus
import com.example.domain.models.movie.info.MovieInfoDomainModel
import com.example.domain.repository.MovieRepository

class DefaultGetMovieInfoUseCase(
    private val repository: MovieRepository,
) : GetMovieInfoUseCase {

    override suspend fun invoke(movieId: Int): ResultStatus<MovieInfoDomainModel> {
        val response = repository.getMovieInfo(movieId)
        return ResultStatus(
            status = response.status,
            data = response.data,
            errorThrowable = response.errorThrowable
        )
    }
}