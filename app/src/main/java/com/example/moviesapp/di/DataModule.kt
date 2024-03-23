package com.example.moviesapp.di

import com.example.data.databases.local.MoviesDao
import com.example.data.databases.local.data.source.MovieCacheDataSource
import com.example.data.databases.local.data.source.MovieCacheDataSourceImpl
import com.example.data.databases.remote.MovieService
import com.example.data.repository.MovieRepositoryImpl
import com.example.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideMoviesCacheDataSource(
        dao: MoviesDao
    ): MovieCacheDataSource = MovieCacheDataSourceImpl(dao)

    @Provides
    fun provideMovies(
        service: MovieService,
        movieCacheRepository: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            service = service,
            movieCacheRepository=movieCacheRepository
        )
    }
}