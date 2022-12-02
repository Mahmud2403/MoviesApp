package com.example.moviesapp.data.network

import javax.inject.Inject

class MoviesRepository @Inject constructor(private val apiService: ApiService) {
	suspend fun getMovies() = apiService.getMovies()
}