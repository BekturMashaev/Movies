package com.example.moviesapp.di

import com.example.domain.repository.MovieRepository
import com.example.domain.use.cases.local.get.GetAllCachedMoviesUseCase
import com.example.domain.use.cases.local.get.GetAllCachedMoviesUseCaseImpl
import com.example.domain.use.cases.local.save.SaveMovieToCacheUseCase
import com.example.domain.use.cases.local.save.SaveMovieToCacheUseCaseImpl
import com.example.domain.use.cases.remote.info.DefaultGetMovieInfoUseCase
import com.example.domain.use.cases.remote.info.GetMovieInfoUseCase
import com.example.domain.use.cases.remote.now.playing.DefaultGetNowPlayingMoviesDataUseCase
import com.example.domain.use.cases.remote.now.playing.GetNowPlayingMoviesDataUseCase
import com.example.domain.use.cases.remote.popular.DefaultGetPopularMoviesDataUseCase
import com.example.domain.use.cases.remote.popular.GetPopularMoviesDataUseCase
import com.example.domain.use.cases.remote.searched.DefaultGetSearchedMoviesUseCase
import com.example.domain.use.cases.remote.searched.GetSearchedMoviesUseCase
import com.example.domain.use.cases.remote.top.rated.DefaultGetTopRatedMoviesDataUseCase
import com.example.domain.use.cases.remote.top.rated.GetTopRatedMoviesDataUseCase
import com.example.domain.use.cases.remote.upcoming.DefaultGetUpcomingMoviesDataUseCase
import com.example.domain.use.cases.remote.upcoming.GetUpcomingMoviesDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun provideGetNowPlayingMoviesUseCase(
        repository: MovieRepository
    ): GetNowPlayingMoviesDataUseCase = DefaultGetNowPlayingMoviesDataUseCase(repository)

    @Provides
    fun provideGetPopularMoviesUseCase(
        repository: MovieRepository
    ): GetPopularMoviesDataUseCase = DefaultGetPopularMoviesDataUseCase(repository)

    @Provides
    fun provideGetTopRatedMoviesUseCase(
        repository: MovieRepository
    ): GetTopRatedMoviesDataUseCase = DefaultGetTopRatedMoviesDataUseCase(repository)

    @Provides
    fun provideGetUpcomingMoviesUseCase(
        repository: MovieRepository
    ): GetUpcomingMoviesDataUseCase = DefaultGetUpcomingMoviesDataUseCase(repository)

    @Provides
    fun provideGetSearchedMoviesUseCase(
        repository: MovieRepository
    ): GetSearchedMoviesUseCase = DefaultGetSearchedMoviesUseCase(repository)

    @Provides
    fun provideGetMovieInfoUseCase(
        repository: MovieRepository,
    ): GetMovieInfoUseCase = DefaultGetMovieInfoUseCase(repository)

    @Provides
    fun provideSaveMovieToCacheUseCase(
        repository: MovieRepository
    ): SaveMovieToCacheUseCase = SaveMovieToCacheUseCaseImpl(repository)

    @Provides
    fun provideGetAllCachedMoviesUseCase(
        repository: MovieRepository
    ): GetAllCachedMoviesUseCase = GetAllCachedMoviesUseCaseImpl(repository)
}