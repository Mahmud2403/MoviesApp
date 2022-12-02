package com.example.moviesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviesapp.MainViewModel
import com.example.moviesapp.sceens.DetailsScreen
import com.example.moviesapp.sceens.MainScreen
import com.example.moviesapp.sceens.SplashScreen
import com.example.moviesapp.utils.Constants

sealed class Screens(val route: String) {
	object Splash : Screens(route = Constants.Screens.SPLASH_SCREEN)
	object Main : Screens(route = Constants.Screens.MAIN_SCREEN)
	object Details : Screens(route = Constants.Screens.DETAILS_SCREEN)
}


@Composable
fun SetupNavHost(navController: NavHostController, viewModel: MainViewModel) {
	NavHost(
		navController = navController,
		startDestination = Screens.Splash.route
	) {
		composable(route = Screens.Splash.route) {
			SplashScreen(navController, viewModel = viewModel)
		}
		composable(route = Screens.Main.route) {
			MainScreen(navController, viewModel)
		}
		composable(route = Screens.Details.route + "/{id}") {
			DetailsScreen(viewModel, id = it.arguments?.getString("id")?: "1")
		}
	}

}