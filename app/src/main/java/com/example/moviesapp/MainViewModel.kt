package com.example.moviesapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.Result
import com.example.moviesapp.data.model.MoviesModel
import com.example.moviesapp.data.network.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MoviesRepository): ViewModel() {

	private val _allMovies = MutableLiveData<List<MoviesModel>>()
	val allMovies: LiveData<List<MoviesModel>>
		get() = _allMovies

	init {
		getAllMovies()
	}

	fun getAllMovies() {
		viewModelScope.launch {
			repository.getMovies().let {
				if (it.isSuccessful){
					_allMovies.value = it.body()
				} else{
					Log.e("checkData", "${it.errorBody()}")
				}
			}
		}
	}
}

sealed interface Result{
	object Loading: com.example.moviesapp.Result
	data class Error(val message: String): com.example.moviesapp.Result
	data class Success(val data: List<MoviesModel> = emptyList()): com.example.moviesapp.Result
}