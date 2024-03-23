package com.example.data.databases.remote

import com.example.data.models.movie.info.MovieInfoDataModel
import com.example.data.models.movie.list.MoviesListResultDataModel
import com.example.data.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET(Constants.Movie.POPULAR)
    suspend fun getPopularMovies(
        @Query("page") page: Int,
    ): Response<MoviesListResultDataModel>

    @GET(Constants.Movie.TOP_RATED)
    suspend fun getTopRatedMovies(
        @Query("page") page: Int,
    ): Response<MoviesListResultDataModel>


    @GET(Constants.Movie.UPCOMING)
    suspend fun getGetUpcomingMovies(
        @Query("page") page: Int,
    ): Response<MoviesListResultDataModel>

    @GET(Constants.Movie.NOW_PLAYING)
    suspend fun getNowPlayingMovies(
        @Query("page") page: Int,
    ): Response<MoviesListResultDataModel>

    @GET(Constants.Movie.MOVIE_DETAILS)
    suspend fun getMovieInfo(
        @Path("movie_id") movieId: Int,
    ): Response<MovieInfoDataModel>

    @GET(Constants.Movie.SIMILAR)
    suspend fun getSimilarMovies(
        @Path("movie_id") movieId: Int,
    ): Response<MoviesListResultDataModel>

    @GET(Constants.Movie.SEARCH_MOVIE)
    suspend fun getSearchedMovies(
        @Query("query") query: String,
    ):Response<MoviesListResultDataModel>
}