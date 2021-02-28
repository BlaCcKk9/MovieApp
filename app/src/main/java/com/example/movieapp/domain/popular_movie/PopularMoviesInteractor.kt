package com.example.movieapp.domain.popular_movie

import com.example.movieapp.data.models.PopularMoviesResModel
import com.example.movieapp.domain.repositories.PopularMoviesRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PopularMoviesInteractor @Inject constructor(
    private val popularMoviesRepository: PopularMoviesRepository
){
    fun execute(): Flowable<PopularMoviesResModel> = popularMoviesRepository.getPopularMovies()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}