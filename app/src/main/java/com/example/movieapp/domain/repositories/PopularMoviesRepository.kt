package com.example.movieapp.domain.repositories

import com.example.movieapp.data.models.MovieResModel
import io.reactivex.Flowable

interface PopularMoviesRepository {
    fun getPopularMovies(api_key: String, page: Int): Flowable<MovieResModel>
}