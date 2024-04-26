package com.wipro.wiproapp.network

import com.wipro.wiproapp.data.model.MovieResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

/**
 * RetrofitService is a network layer interface create the HTTPApiClient object in an companion object to call the APIs
 * It takes care of network API calls to be called desired source
 */
interface RetrofitService {

    /**
     * Method to call the particular endpoint with if any inputs are there
     */
    @GET("3/movie/popular")
    fun getPopularMovies(): Call<MovieResponse?>

    /**
     * Companion object and it's members can be used from multiple places with
     * its static reference
     */
    companion object{
        var retrofitService: RetrofitService? = null

        /**
         * This method returns the Retrofit client reference to initiate the API calls
         */
        fun getInstance(): RetrofitService {

            /**
             * This Okhttp client is used to add an interceptor which has ability to deal with
             * Authorization bearer token to used while API call for authentication
             */
            val client = OkHttpClient.Builder()
                .addInterceptor(TokenInterceptor())
                .build()

            if(retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .baseUrl("https://api.themoviedb.org/")
                    .build()

                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}