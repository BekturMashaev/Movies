package com.example.data.databases.local.data.source

import com.example.data.databases.local.MoviesCacheModel
import kotlinx.coroutines.flow.Flow

interface MovieCacheDataSource {
    suspend fun addMovieToCache(cacheModel: MoviesCacheModel)
    fun getAllCachedMovies():Flow<List<MoviesCacheModel>>
    suspend fun deleteMovieByID(movieID:Int)
    suspend fun clearMovieTable()
    suspend fun getMovieById(movieID: Int): MoviesCacheModel
}