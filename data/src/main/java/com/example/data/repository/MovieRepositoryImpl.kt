package com.example.data.repository

import android.util.Log
import com.example.data.databases.local.data.source.MovieCacheDataSource
import com.example.data.databases.remote.MovieService
import com.example.data.mappers.toCache
import com.example.data.mappers.toDomain
import com.example.data.mappers.toDomainModel
import com.example.domain.base.BaseDataSource
import com.example.domain.base.models.ResultStatus
import com.example.domain.models.movie.info.MovieInfoDomainModel
import com.example.domain.models.movie.list.MoviesListResultDomainModel
import com.example.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val service: MovieService,
    private val movieCacheRepository: MovieCacheDataSource,
) : MovieRepository, BaseDataSource() {
    override suspend fun getNowPlayingMovies(
        page: Int
    ): ResultStatus<MoviesListResultDomainModel> {
        val response = invokeResponseRequest { service.getNowPlayingMovies(page = page) }
        return ResultStatus(
            status = response.status,
            data = response.data?.toDomainModel(),
            errorThrowable = response.errorThrowable,
        )
    }

    override suspend fun getTopRatedMovies(page: Int): ResultStatus<MoviesListResultDomainModel> {
        val response = invokeResponseRequest { service.getTopRatedMovies(page = page) }
        return ResultStatus(
            status = response.status,
            data = response.data?.toDomainModel(),
            errorThrowable = response.errorThrowable,
        )
    }

    override suspend fun getUpcomingMovies(page: Int): ResultStatus<MoviesListResultDomainModel> {
        val response = invokeResponseRequest { service.getGetUpcomingMovies(page = page) }
        return ResultStatus(
            status = response.status,
            data = response.data?.toDomainModel(),
            errorThrowable = response.errorThrowable,
        )
    }

    override suspend fun getPopularMovies(page: Int): ResultStatus<MoviesListResultDomainModel> {
        val response = invokeResponseRequest { service.getPopularMovies(page = page) }
        return ResultStatus(
            status = response.status,
            data = response.data?.toDomainModel(),
            errorThrowable = response.errorThrowable,
        )
    }

    override suspend fun getMovieInfo(
        movieId: Int
    ): ResultStatus<MovieInfoDomainModel> {
        val response = invokeResponseRequest {
            service.getMovieInfo(
                movieId = movieId
            )
        }
        return ResultStatus(
            status = response.status,
            data = response.data?.toDomain(),
            errorThrowable = response.errorThrowable
        )
    }

    override suspend fun getSearchedMovies(query: String): ResultStatus<MoviesListResultDomainModel> {
        val response = invokeResponseRequest {
            service.getSearchedMovies(
                query = query
            )
        }
        return ResultStatus(
            status = response.status,
            data = response.data?.toDomainModel(),
            errorThrowable = response.errorThrowable
        )
    }

    override suspend fun saveMovieToCache(model: MovieInfoDomainModel) {
        movieCacheRepository.addMovieToCache(cacheModel = model.toCache())
        Log.d("AAA","model ${model.toCache()}")
    }

    override fun getAllCachedMovies(): Flow<List<MovieInfoDomainModel>> {
         val movies= movieCacheRepository.getAllCachedMovies().map { listOfModels ->
            listOfModels.map { model ->
                model.toDomain()
            }
        }
        Log.d("AAA","movies")
        Log.d("AAA","movies $movies")
        return movies
    }
}