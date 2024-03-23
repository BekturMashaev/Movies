package com.example.data.utils

object Constants{
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val API_KEY="eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyYThmMDlhNDJmYmIxZmU4NWIzOGRmMjQ2ZGU0MjBkNSIsInN1YiI6IjY1Yjc3MjU2YTI4NGViMDE3YzBiYzBiMCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.5dIsnpMUsfEi5Hjlh7pAVFUXjdOcTSAsFzi7IICKdpI"
    const val POSTER_PATH_URL = "https://image.tmdb.org/t/p/original/"
    const val LANGUAGE_RU = "ru"
    const val LANGUAGE_EN = "en"
    const val YOUTUBE_URL = "https://www.youtube.com/watch?v="
    object Movie {
        const val POPULAR = "movie/popular"
        const val TOP_RATED = "movie/top_rated"
        const val UPCOMING = "movie/upcoming"
        const val NOW_PLAYING = "movie/now_playing"
        const val SEARCH_MOVIE = "search/movie"
        const val MOVIE_DETAILS = "movie/{movie_id}"
        const val SIMILAR = "movie/{movie_id}/similar"
        const val RECOMMENDATIONS = "movie/{movie_id}/recommendations"
        const val RATE_MOVIE = "movie/{movie_id}/rating"
        const val DELETE_RATE = "movie/{movie_id}/rating"
    }

    object TVSerials {
        const val TRENDING_TV = "trending/tv/day"
        const val TOP_RATED_TV = "tv/top_rated"
        const val ON_THE_AIR_TV = "tv/on_the_air"
        const val POPULAR_TV = "tv/popular"
        const val AIRING_TODAY_TV = "tv/airing_today"
    }

    object TRAILER {
        const val MOVIE_TRAILERS = "movie/{movie_id}/videos"
    }

    object Person {
        const val SEARCH_PEOPLE = "search/person"
        const val PERSON_POPULAR = "person/popular"
        const val PERSON_DETAILS = "person/{person_id}"
    }
}