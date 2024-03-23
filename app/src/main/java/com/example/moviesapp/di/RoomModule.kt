package com.example.moviesapp.di

import android.content.Context
import androidx.room.Room
import com.example.data.databases.local.MoviesDao
import com.example.data.databases.local.MoviesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    fun provideMoviesDao(
        database: MoviesDatabase
    ): MoviesDao = database.getMovieDao()

    @Singleton
    @Provides
    fun provideDataBase(
        @ApplicationContext context: Context
    ): MoviesDatabase = Room.databaseBuilder(
        context = context,
        MoviesDatabase::class.java,
        "movies_database"
    ).build()
}