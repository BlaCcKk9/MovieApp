package com.example.movieapp.domain.movie_detail

import com.example.movieapp.app.API_KEY
import com.example.movieapp.data.models.MovieResModel
import com.example.movieapp.domain.repositories.MovieDetailRepository
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieDetailInteractor @Inject constructor(
    private val movieDetailRepository: MovieDetailRepository
){
    fun execute(id: Int): Flowable<MovieResModel> = movieDetailRepository.getSimilarMovies(id, API_KEY)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}