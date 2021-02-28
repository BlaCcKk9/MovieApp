package com.example.movieapp.data.models

import com.google.gson.annotations.SerializedName

data class PopularMoviesResModel(
    @SerializedName("page")
    var page: Int,
    @SerializedName("results")
    var results: List<MovieModel>,
    @SerializedName("total_results")
    var totalResults: Int,
    @SerializedName("total_pages")
    var totalPages: Int
)
