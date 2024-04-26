package com.wipro.wiproapp.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wipro.wiproapp.R
import com.wipro.wiproapp.data.model.Movie
import com.wipro.wiproapp.databinding.LayoutRvItemBinding
import com.wipro.wiproapp.utils.Constants

/**
 * This class takes care of the loading data in recyclerview in efficient manner
 */
class MovieListAdapter : RecyclerView.Adapter<MovieViewHolder>() {
    var movieList = mutableListOf<Movie>()

    fun setMovieData(list: List<Movie>) {
        this.movieList = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutRvItemBinding.inflate(inflater, parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.binding.movieTitle.text = movie.title
        holder.binding.movieYear.text = "Release Date: ${movie.releaseDate}"
        holder.binding.movieOverview.text = "Overview: ${movie.overview}"
        holder.binding.movieGen.text = "Popularity: ${movie.popularity}"
        Glide.with(holder.itemView.context).load(Constants.imageBasePath + movie.posterPath)
            .placeholder(R.drawable.placeholder)
            .into(holder.binding.moviePoster)
    }
}

class MovieViewHolder(val binding: LayoutRvItemBinding) : RecyclerView.ViewHolder(binding.root) {}