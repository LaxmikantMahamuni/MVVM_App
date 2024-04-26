package com.wipro.wiproapp.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.wipro.wiproapp.databinding.ActivityMainBinding
import com.wipro.wiproapp.network.RetrofitService
import com.wipro.wiproapp.repository.MovieRepository
import com.wipro.wiproapp.viewmodel.MovieListViewModel
import com.wipro.wiproapp.viewmodel.MovieViewModelFactory

/**
 * This class is the view where user will se the UI and he/she can
 * perform operations on it lik button press, text input etc.
 */
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MovieListViewModel

    private val retrofitService = RetrofitService.getInstance()
    val adapter = MovieListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressbar.visibility = View.VISIBLE

        //Get viewmodel instance using MyViewModelFactory
        viewModel =
            ViewModelProvider(this, MovieViewModelFactory(MovieRepository(retrofitService))).get(
                MovieListViewModel::class.java
            )

        //set recyclerview adapter
        binding.recyclerview.adapter = adapter

        // Observes the response and update the view accordingly
        viewModel.movieList.observe(this, Observer {
            binding.progressbar.visibility = View.GONE
            if (it != null) {
                Log.d(TAG, "movieList: $it")
                adapter.setMovieData(it)
            } else {
                Log.d(TAG, "movieList: Null")
            }
        })

        // Observes the response and update the view accordingly
        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")
        })

        //Initiate API call
        viewModel.getPopularMovies()
    }
}