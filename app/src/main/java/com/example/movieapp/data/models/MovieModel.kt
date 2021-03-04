package com.example.movieapp.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieModel (
    @SerializedName("id")
    var id: Int,
    @SerializedName("poster_path")
    var image: String?,
    @SerializedName("backdrop_path")
    var background: String?,
    @SerializedName("popularity")
    var popularity: Double,
    @SerializedName("vote_average")
    var voteAverage: Double,
    @SerializedName("overview")
    var description: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("origin_country")
    var country: List<String>,
    @SerializedName("original_language")
    var language: String,
    @SerializedName("first_air_date")
    var date: String
) : Serializable
