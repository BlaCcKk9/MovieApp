package com.example.movieapp.data.repositories

import com.example.movieapp.data.data_providers.remote.RemoteDataProvider
import com.example.movieapp.data.models.MovieResModel
import com.example.movieapp.domain.repositories.PopularMoviesRepository
import io.reactivex.Flowable
import javax.inject.Inject

class PopularMoviesRepositoryImpl @Inject constructor(
    private val remoteDataProvider: RemoteDataProvider
): PopularMoviesRepository {

    override fun getPopularMovies(api_key: String, page: Int): Flowable<MovieResModel> = remoteDataProvider.getPopularMovies(api_key, page)

}