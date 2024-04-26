package com.wipro.wiproapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wipro.wiproapp.repository.MovieRepository

/**
 * Factory class to create a object of view-model
 */
class MovieViewModelFactory constructor(val movieRepository: MovieRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(MovieListViewModel::class.java)) {
            MovieListViewModel(this.movieRepository) as T
        } else{
            throw IllegalArgumentException("ViewModel not found.")
        }
    }
}