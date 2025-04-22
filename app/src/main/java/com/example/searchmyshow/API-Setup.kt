package com.example.searchmyshow

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface OMDBService {
    @GET(".")
    suspend fun searchMovies(
        @Query("apikey") apiKey: String,
        @Query("s") query: String
    ): MovieList
}

val retrofitInstance: Retrofit =
    Retrofit.Builder().baseUrl("https://www.omdbapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()


val networkCall : OMDBService = retrofitInstance.create(OMDBService::class.java)