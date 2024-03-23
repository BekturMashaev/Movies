package com.example.moviesapp.di

import com.example.data.databases.remote.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://api.themoviedb.org/3/"
private const val API_KEY =
    "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyYThmMDlhNDJmYmIxZmU4NWIzOGRmMjQ2ZGU0MjBkNSIsInN1YiI6IjY1Yjc3MjU2YTI4NGViMDE3YzBiYzBiMCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.5dIsnpMUsfEi5Hjlh7pAVFUXjdOcTSAsFzi7IICKdpI"

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {
    @Provides
    @Singleton
    fun provideMoviesService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .addInterceptor(Interceptor { chain ->
                        val request = chain.request()
                            .newBuilder()
                            .addHeader("Authorization", "Bearer $API_KEY")
                            .build()
                        return@Interceptor chain.proceed(request = request)
                    }).build()
            ).build()
    }
}