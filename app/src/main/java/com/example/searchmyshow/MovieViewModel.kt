package com.example.searchmyshow

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val apikey = "a9a8a482"
    private val _movieInstance = mutableStateOf(MovieState())
    var check : MutableState<Boolean> = mutableStateOf(false)
    val movieInstance : State<MovieState> = _movieInstance
    val showName = mutableStateOf("")

    data class MovieState(
        val loading: Boolean = true,
        val list: List<MovieData> = emptyList(),
        val error: String? = null,
        )

    fun movie(movieName: String){
        viewModelScope.launch {
            try {
                val apiInstance = networkCall.searchMovies(apikey, movieName)
                _movieInstance.value = _movieInstance.value.copy(
                    loading = false,
                    list = apiInstance.Search,
                    error = null
                )

            }
            catch (e : Exception){
                _movieInstance.value = _movieInstance.value.copy(
                    loading = false,
                    error = "Error Occurred! ${e.message}"
                )
            }
        }
    }
}