package com.example.domain.models.movie.list

import java.io.Serializable

data class MoviesListResultDomainModel(
    val results: List<MovieResultDomainModel>,
) : Serializable {
    companion object {
        val unknown = MoviesListResultDomainModel(
            results = listOf(
                MovieResultDomainModel.unknown
            ),
        )
    }
}