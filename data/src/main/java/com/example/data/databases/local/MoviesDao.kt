package com.example.data.databases.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovieToCache(movieModelCache: MoviesCacheModel)

    @Query("SELECT * FROM movie_table_name")
    fun getCachedAllSavedMovies(): Flow<List<MoviesCacheModel>>

    @Query("SELECT * FROM movie_table_name WHERE id=:id")
    suspend fun getCachedMovieById(id: Int): MoviesCacheModel

    @Query("DELETE  FROM movie_table_name WHERE id = :movieId")
    suspend fun deleteCachedMovieById(movieId: Int)

    @Query("DELETE  FROM movie_table_name")
    suspend fun clearMovieTable()
}