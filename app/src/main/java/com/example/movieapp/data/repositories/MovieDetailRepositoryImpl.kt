package com.example.movieapp.data.repositories

import com.example.movieapp.data.data_providers.remote.RemoteDataProvider
import com.example.movieapp.domain.repositories.MovieDetailRepository
import javax.inject.Inject

class MovieDetailRepositoryImpl @Inject constructor(
    private val remoteDataProvider: RemoteDataProvider
) : MovieDetailRepository{
    override fun getMovieDetail() {
      // do something
    }
}