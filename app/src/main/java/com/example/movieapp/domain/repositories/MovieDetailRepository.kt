package com.example.movieapp.domain.repositories

import com.example.movieapp.data.models.MovieResModel
import io.reactivex.Flowable

interface MovieDetailRepository {
    fun getSimilarMovies(id: Int, api_key: String): Flowable<MovieResModel>
}