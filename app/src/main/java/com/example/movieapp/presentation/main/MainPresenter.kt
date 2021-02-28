package com.example.movieapp.presentation.main

import android.util.Log
import com.example.movieapp.app.scopes.PerActivity
import com.example.movieapp.domain.popular_movie.PopularMoviesInteractor
import com.example.movieapp.presentation.base.BasePresenter
import javax.inject.Inject

@PerActivity
class MainPresenter @Inject constructor(
    private val popularMoviesInteractor: PopularMoviesInteractor
) : BasePresenter<MainView>(){

    override fun onFirstAttach() {
        super.onFirstAttach()
        Log.e("Iamhere->>>>", "ahahhahah")
//        addDisposable(popularMoviesInteractor.execute().subscribe {
//            view?.populatePopularMovies(it.results)
//        })

        addDisposable(popularMoviesInteractor.execute().subscribe({
            view?.populatePopularMovies(it.results)
        }, {
            Log.e("errorr", it.message.toString())
        }))
    }
}