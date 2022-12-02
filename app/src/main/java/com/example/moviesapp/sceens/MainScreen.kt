package com.example.moviesapp.sceens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.moviesapp.MainViewModel
import com.example.moviesapp.Result
import com.example.moviesapp.data.model.MoviesModel
import com.example.moviesapp.navigation.Screens

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
		LazyColumn(modifier = Modifier.padding(top = 20.dp)){
			items(allMovies.take(10)){
				MovieItem(item = it, navController)
			}
		}
	}
}

@Composable
fun MovieItem(item: MoviesModel, navController: NavController) {
	Card(
		elevation = 4.dp,
		modifier = Modifier
			.padding(10.dp)
			.clickable {
				navController.navigate(Screens.Details.route + "/${item.id}")
			},
		shape = MaterialTheme.shapes.medium,
		backgroundColor = MaterialTheme.colors.background,
	){
		Row(modifier = Modifier
			.fillMaxWidth()
			.padding(vertical = 16.dp)
		) {
			Image(
				painter = rememberImagePainter(item.image.original),
				modifier = Modifier.size(128.dp),
				contentDescription = null
			)
			Column {
				Text(
					text = item.name,
					fontSize = 24.sp,
					fontWeight = FontWeight.Bold
				)
				Row {
					Text(
						text = "Rating: ",
						fontWeight = FontWeight.Bold
					)
					Text(text = item.rating.average.toString())
				}
				Row {
					Text(
						text = "Genre: ",
						fontWeight = FontWeight.Bold
					)
					item.genres.take(2).forEach{ Text(text = " $it ")}
				}
				Row {
					Text(
						text = "Premiered: ",
						fontWeight = FontWeight.Bold
					)
					Text(text = item.premiered)
				}
			}
		}
	}

}