package com.example.movieapp.presentation.movie_detail

import com.example.movieapp.data.models.MovieModel
import com.example.movieapp.presentation.base.BaseView

interface MovieDetailView: BaseView {
    fun populateSimilarMovies(movies: List<MovieModel>)
}