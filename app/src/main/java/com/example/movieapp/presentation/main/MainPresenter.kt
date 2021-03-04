package com.example.movieapp.presentation.main

import android.util.Log
import com.example.movieapp.app.API_KEY
import com.example.movieapp.app.scopes.PerActivity
import com.example.movieapp.data.models.MovieModel
import com.example.movieapp.domain.popular_movie.PopularMoviesInteractor
import com.example.movieapp.presentation.base.BasePresenter
import javax.inject.Inject

@PerActivity
class MainPresenter @Inject constructor(
    private val popularMoviesInteractor: PopularMoviesInteractor
) : BasePresenter<MainView>(){

    private var popularMovies = ArrayList<MovieModel>()

    override fun onFirstAttach() {
        super.onFirstAttach()
        getPopularMovies(1)
    }

    fun getPopularMovies(page: Int){
        addDisposable(popularMoviesInteractor.execute(page).doOnSubscribe { view?.setProgressVisibility(true) }.doAfterTerminate { view?.setProgressVisibility(false)}.subscribe({
            popularMovies.addAll(it.results)
            view?.populatePopularMovies(popularMovies)
        }, {
            Log.e("errorr", it.message.toString())
        }))
    }
}