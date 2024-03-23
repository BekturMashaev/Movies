package com.example.data.models.movie.list

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MoviesListResultDataModel(
    @SerializedName("results")
    val results: List<MovieResultDataModel>,
) : Serializable {
    companion object {
        val unknown = MoviesListResultDataModel(
            results = listOf(
                MovieResultDataModel.unknown
            ),
        )
    }
}
