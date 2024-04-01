package com.example.recipeeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun RecipeApp(navController: NavHostController){
    val recipeViewModel:MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route ){
        composable(Screen.RecipeScreen.route){
            RecipeScreen(navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("cat",it)
                navController.navigate(Screen.DetailScreen.route)
            }, viewState = viewState)
        }
        composable(Screen.DetailScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat") ?: Category("","","","")
            DetailedView(category = category, navigateToRecipeScreen = {
                navController.navigate(Screen.RecipeScreen.route)
            })
        }
    }
}