package com.example.moviesapp.sceens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.moviesapp.MainViewModel
import com.example.moviesapp.utils.HtmlText

@Composable
fun DetailsScreen(viewModel: MainViewModel, id: String) {
	val currentItem = viewModel.allMovies
		.observeAsState(listOf()).value
		.firstOrNull { it.id == id.toInt() }

	Surface(
		modifier = Modifier
			.fillMaxSize()
			.background(MaterialTheme.colors.background),
	) {
		LazyColumn {
			item {
				Column(
					horizontalAlignment = Alignment.CenterHorizontally
				) {
					Image(
						painter = rememberImagePainter(currentItem?.image?.medium),
						contentDescription = null,
						modifier = Modifier
							.size(518.dp)
							.padding(top = 16.dp)
					)
					Text(
						text = currentItem?.name ?: "",
						fontWeight = FontWeight.Bold,
						fontSize = 32.sp,
						modifier = Modifier.padding(top = 16.dp)
					)
					Row {
						Text(
							text = "Rating: ",
							fontWeight = FontWeight.Bold,
							fontSize = 18.sp
						)
						Text(text = currentItem?.rating?.average.toString())
					}
					Row {
						Text(
							text = "Genre: ",
							fontWeight = FontWeight.Bold,
							fontSize = 18.sp
						)
						currentItem?.genres?.take(2)?.forEach {
							Text(
								text = " [$it] ",
								fontSize = 18.sp
							)
						}
					}
					HtmlText(
						html = currentItem?.summary ?: "",
						modifier = Modifier.padding(top = 10.dp)
					)
				}
			}
		}
	}
}