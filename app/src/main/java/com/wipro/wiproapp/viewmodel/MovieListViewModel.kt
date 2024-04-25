package com.wipro.wiproapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wipro.wiproapp.data.model.Movie
import com.wipro.wiproapp.data.model.MovieResponse
import com.wipro.wiproapp.repository.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListViewModel constructor(val movieRepository: MovieRepository) : ViewModel() {
    val movieList = MutableLiveData<List<Movie>>()
    val errorMessage = MutableLiveData<String>()

    fun getPopularMovies() {
        val call: Call<MovieResponse?> = movieRepository.getPopularMovies()
        call.enqueue(object : Callback<MovieResponse?> {
            override fun onResponse(
                call: Call<MovieResponse?>,
                response: Response<MovieResponse?>
            ) {
                Log.d("TAG", response.code().toString() + "")
                Log.d("RESPO", "Response is here ${response.body().toString()}")
                movieList.postValue(response.body()?.movies)
            }

            override fun onFailure(call: Call<MovieResponse?>, t: Throwable) {
                movieList.postValue(null)
                call.cancel()
            }
        })
    }
}