package com.wipro.wiproapp.data.model


import com.google.gson.annotations.SerializedName

/**
 * Data class to parse api response into structured way to be used
 * in throughout the application
 */
data class MovieResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val movies: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Long,
    @SerializedName("total_results")
    val totalResults: Long
)