package com.example.movieapp.presentation.movie_detail

import com.example.movieapp.app.scopes.PerActivity
import com.example.movieapp.data.models.MovieModel
import com.example.movieapp.domain.movie_detail.MovieDetailInteractor
import com.example.movieapp.presentation.base.BasePresenter
import javax.inject.Inject

@PerActivity
class MovieDetailPresenter @Inject constructor(
    private val movieDetailInteractor: MovieDetailInteractor
) : BasePresenter<MovieDetailView>() {

    private var similarMovies = ArrayList<MovieModel>()

    fun getSimilarMovies(id: Int) {
        addDisposable(movieDetailInteractor.execute(id).subscribe({
            similarMovies.addAll(it.results)
            view?.populateSimilarMovies(similarMovies)
        }, {

        }))
    }
}