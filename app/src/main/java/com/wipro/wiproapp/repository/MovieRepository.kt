package com.wipro.wiproapp.repository

import com.wipro.wiproapp.data.model.MovieResponse
import com.wipro.wiproapp.network.RetrofitService
import retrofit2.Call

class MovieRepository constructor(val retrofitService: RetrofitService) {
    fun getPopularMovies() : Call<MovieResponse?> {
        return retrofitService.getPopularMovies()
    }
}