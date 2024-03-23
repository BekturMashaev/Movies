package com.example.data.models.movie.info

import com.google.gson.annotations.SerializedName


data class ProductionCountries(
    @SerializedName("iso_3166_1")
    val name:String
)
