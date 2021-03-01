package com.example.movieapp.domain.repositories

import com.example.movieapp.data.models.PopularMoviesResModel
import io.reactivex.Flowable
import io.reactivex.Single

interface PopularMoviesRepository {
    fun getPopularMovies(api_key: String, page: Int): Flowable<PopularMoviesResModel>
}