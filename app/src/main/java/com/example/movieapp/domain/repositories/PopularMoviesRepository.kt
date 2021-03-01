package com.example.movieapp.domain.repositories

import com.example.movieapp.data.models.PopularMoviesResModel
import io.reactivex.Flowable
import io.reactivex.Single

interface PopularMoviesRepository {
    fun getPopularMovies(api_key: String): Flowable<PopularMoviesResModel>
    fun getPopularMovies(api_key: String, page: Long): Flowable<PopularMoviesResModel>
}