package com.example.movieapp.data.data_providers.remote

import com.example.movieapp.app.VERSION
import com.example.movieapp.data.models.PopularMoviesResModel
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteDataProvider {
    @GET("$VERSION/tv/popular")
    fun getPopularMovies(@Query("api_key") api_key: String, @Query("page") page: Int) : Flowable<PopularMoviesResModel>
}