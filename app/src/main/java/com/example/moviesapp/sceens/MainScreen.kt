package com.example.moviesapp.sceens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moviesapp.MainViewModel
import com.example.moviesapp.Result

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {


	val allMovies = viewModel.allMovies.observeAsState(Result.Loading)
	val scrollState = rememberScrollState()
	androidx.compose.material.Surface(modifier = Modifier.fillMaxSize()) {
		when (val uiState = allMovies.value) {
			is Result.Error -> {
				//todo
			}
			Result.Loading -> {
				//todo
			}
			is Result.Success -> {
				Column(
					modifier = Modifier.verticalScroll(scrollState),
					verticalArrangement = Arrangement.spacedBy(15.dp)
				) {
					uiState.data.forEach {
						Text(text = it.id.toString())
					}
				}
			}
		}
	}


}