package com.one.visionadmin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.one.visionadmin.databinding.MovieCardBinding
import com.one.visionadmin.models.Movie

class WatchListAdapter: RecyclerView.Adapter<WatchListAdapter.WatchListViewHolder>() {

    private lateinit var moviesList: ArrayList<Movie>
    private lateinit var context: Context
    var onItemClick: ((Movie) -> Unit)? = null

    fun setMovieList(context: Context, moviesList: ArrayList<Movie>){
        this.moviesList = moviesList
        this.context = context
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchListViewHolder {
        return WatchListViewHolder(MovieCardBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: WatchListViewHolder, position: Int) {
        val movie = moviesList[position]
        Glide.with(context)
            .load(movie.image)
            .into(holder.binding.movieCardImg)
        holder.binding.movieCardRatingsTv.text = movie.rating
        if(movie.isPrime == true){
            holder.binding.movieCardPrimeIconLayout.visibility = View.VISIBLE
        }else{
            holder.binding.movieCardPrimeIconLayout.visibility = View.GONE
        }
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(movie)
        }
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    inner class WatchListViewHolder(val binding: MovieCardBinding): RecyclerView.ViewHolder(binding.root)
}