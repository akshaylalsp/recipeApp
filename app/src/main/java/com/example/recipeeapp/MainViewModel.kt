package com.example.recipeeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
class MainViewModel : ViewModel() {

    init {
        fetchData()
    }

    private var _categoriesState = mutableStateOf(RecipeState())
    val categoriesState : State<RecipeState> = _categoriesState
    data class RecipeState(
        val loading:Boolean = true,
        val list : List<Category> = emptyList(),
        val error : String? = null
    )
    private fun fetchData(){
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(loading = false, error = null, list = response.categories)
            }
            catch (e:Exception){
                _categoriesState.value = _categoriesState.value.copy(error = "${e.message}", loading = false)
            }
        }
    }
}