package com.example.movieapp.presentation.main

import com.example.movieapp.data.models.MovieModel
import com.example.movieapp.presentation.base.BaseView

interface MainView : BaseView {
    fun populatePopularMovies(movies: List<MovieModel>)
    fun setProgressVisibility(isVisible: Boolean)
}