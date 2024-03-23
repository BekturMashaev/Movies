package com.example.data.databases.local.data.source

import android.util.Log
import com.example.data.databases.local.MoviesCacheModel
import com.example.data.databases.local.MoviesDao
import com.example.data.mappers.toCache
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieCacheDataSourceImpl @Inject constructor(
    private val moviesDao: MoviesDao
) : MovieCacheDataSource {

    override suspend fun addMovieToCache(cacheModel: MoviesCacheModel) {
        Log.d("AAA", "modelof addd")
        moviesDao.addMovieToCache(movieModelCache = cacheModel)
        Log.d("AAA", "modelof addd $cacheModel")
    }

    override fun getAllCachedMovies(): Flow<List<MoviesCacheModel>> {
        Log.d("AAA","$")
        val a=moviesDao.getCachedAllSavedMovies()
        Log.d("AAA","$a")
        return a
    }

    override suspend fun deleteMovieByID(movieID: Int) {
        moviesDao.deleteCachedMovieById(movieId = movieID)
    }

    override suspend fun clearMovieTable() {
        moviesDao.clearMovieTable()
    }

    override suspend fun getMovieById(movieID: Int): MoviesCacheModel {
        return moviesDao.getCachedMovieById(movieID)
    }
}