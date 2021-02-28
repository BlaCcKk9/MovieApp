package com.example.movieapp.data.data_providers.remote

import com.example.movieapp.app.VERSION
import com.example.movieapp.data.models.PopularMoviesResModel
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET

interface RemoteDataProvider {
    @GET("$VERSION/tv/popular?api_key=226d57aee86660948642b81ecba440f8")
    fun getPopularMovies() : Flowable<PopularMoviesResModel>
}