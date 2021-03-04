package com.example.movieapp.domain.popular_movie

import com.example.movieapp.app.API_KEY
import com.example.movieapp.data.models.MovieResModel
import com.example.movieapp.domain.repositories.PopularMoviesRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PopularMoviesInteractor @Inject constructor(
    private val popularMoviesRepository: PopularMoviesRepository
){
    fun execute(page: Int): Flowable<MovieResModel> = popularMoviesRepository.getPopularMovies(API_KEY, page)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}