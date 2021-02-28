package com.example.movieapp.domain.movie_detail

import com.example.movieapp.domain.repositories.MovieDetailRepository
import javax.inject.Inject

class MovieDetailInteractor @Inject constructor(
    private val movieDetailRepository: MovieDetailRepository
){

}