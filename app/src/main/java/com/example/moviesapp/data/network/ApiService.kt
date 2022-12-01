package com.example.moviesapp.data.network

import com.example.moviesapp.data.model.MoviesModel
import retrofit2.Response
import retrofit2.http.GET

// https://api.tvmaze.com/shows/1

interface ApiService {
	@GET("/shows")
	suspend fun getMovies(): Response<List<MoviesModel>>
}