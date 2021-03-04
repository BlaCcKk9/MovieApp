package com.example.movieapp.data.repositories

import com.example.movieapp.data.data_providers.remote.RemoteDataProvider
import com.example.movieapp.data.models.MovieResModel
import com.example.movieapp.domain.repositories.MovieDetailRepository
import io.reactivex.Flowable
import javax.inject.Inject

class MovieDetailRepositoryImpl @Inject constructor(
    private val remoteDataProvider: RemoteDataProvider
) : MovieDetailRepository{
    override fun getSimilarMovies(id: Int, api_key: String): Flowable<MovieResModel>  = remoteDataProvider.getSimilarMovies(id, api_key)

}