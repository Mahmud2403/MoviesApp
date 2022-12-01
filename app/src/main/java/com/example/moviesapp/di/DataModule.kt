package com.example.moviesapp.di

import com.example.moviesapp.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

	companion object {

		private const val BASE_URL = "http://api/tvmaze.com"
	}

	@Provides
	@ViewModelScoped
	fun provideRetrofit(): ApiService = Retrofit.Builder()
		.baseUrl(BASE_URL)
		.addConverterFactory(GsonConverterFactory.create())
		.build()
		.create(ApiService::class.java)
}