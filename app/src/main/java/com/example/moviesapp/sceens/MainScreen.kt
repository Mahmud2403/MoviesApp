package com.example.moviesapp.sceens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moviesapp.MainViewModel
import com.example.moviesapp.Result
import com.example.moviesapp.data.model.MoviesModel

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {


//	val allMovies = viewModel.allMovies.observeAsState(Result.Loading)
//	val scrollState = rememberScrollState()
//	Surface(modifier = Modifier.fillMaxSize()) {
//		when (val uiState = allMovies.value) {
//			is Result.Error -> {
//				//todo
//			}
//			Result.Loading -> {
//				//todo
//			}
//			is Result.Success -> {
//				Column(
//					modifier = Modifier.verticalScroll(scrollState),
//					verticalArrangement = Arrangement.spacedBy(15.dp)
//				) {
//					uiState.data.forEach {
//						MovieItem(item = it)
//					}
//				}
//			}
//		}
//	}

	val allMovies = viewModel.allMovies.observeAsState(listOf()).value
	Surface(
		modifier = Modifier.fillMaxSize()
	) {
		LazyColumn{
			items(allMovies.take(10)){
				MovieItem(item = it)
			}
		}
	}
}

@Composable
fun MovieItem(item: MoviesModel) {
	Row() {
		Text(text = item.id.toString())
		Text(
			text = item.name,
			modifier = Modifier
				.padding(start = 16.dp)
		)
	}
}