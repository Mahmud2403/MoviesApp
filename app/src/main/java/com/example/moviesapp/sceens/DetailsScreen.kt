package com.example.moviesapp.sceens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.moviesapp.MainViewModel
import com.example.moviesapp.navigation.Screens

@Composable
fun DetailsScreen(navController: NavController, viewModel: MainViewModel, id: String) {
	Text(text = "Details screen: item id = $id")
}