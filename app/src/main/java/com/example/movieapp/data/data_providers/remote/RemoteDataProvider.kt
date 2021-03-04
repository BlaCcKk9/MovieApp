package com.example.movieapp.data.data_providers.remote

import com.example.movieapp.app.VERSION
import com.example.movieapp.data.models.MovieResModel
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RemoteDataProvider {
    @GET("$VERSION/tv/popular")
    fun getPopularMovies(@Query("api_key") api_key: String, @Query("page") page: Int) : Flowable<MovieResModel>

    @GET("$VERSION/tv/{tv_id}/similar")
    fun getSimilarMovies(@Path("tv_id") id: Int, @Query("api_key") apiKey: String): Flowable<MovieResModel>
}