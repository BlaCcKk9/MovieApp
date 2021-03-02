package com.example.movieapp.data.models

import com.google.gson.annotations.SerializedName

data class MovieModel (
    @SerializedName("id")
    var id: Int,
    @SerializedName("poster_path")
    var image: String?,
    @SerializedName("popularity")
    var popularity: Double,
    @SerializedName("vote_average")
    var voteAverage: Double,
    @SerializedName("name")
    var name: String,
    @SerializedName("origin_country")
    var country: List<String>,
    @SerializedName("original_language")
    var language: String,
    @SerializedName("first_air_date")
    var date: String
)
