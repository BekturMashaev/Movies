package com.example.domain.repository

import com.example.domain.base.models.ResultStatus
import com.example.domain.models.movie.info.MovieInfoDomainModel
import com.example.domain.models.movie.list.MoviesListResultDomainModel
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    /** remote **/
    suspend fun getNowPlayingMovies(
        page: Int
    ): ResultStatus<MoviesListResultDomainModel>

    suspend fun getTopRatedMovies(
        page: Int
    ): ResultStatus<MoviesListResultDomainModel>

    suspend fun getUpcomingMovies(
        page: Int
    ): ResultStatus<MoviesListResultDomainModel>

    suspend fun getPopularMovies(
        page: Int
    ): ResultStatus<MoviesListResultDomainModel>

    suspend fun getMovieInfo(movieId: Int): ResultStatus<MovieInfoDomainModel>

    suspend fun getSearchedMovies(query: String): ResultStatus<MoviesListResultDomainModel>

    /** local **/
    suspend fun saveMovieToCache(model: MovieInfoDomainModel)

    fun getAllCachedMovies(): Flow<List<MovieInfoDomainModel>>
}