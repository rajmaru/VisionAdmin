package com.one.visionadmin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.one.visionadmin.databinding.MovieItemBinding
import com.one.visionadmin.models.Movie

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private lateinit var moviesList: ArrayList<Movie>
    private lateinit var context: Context
    var onItemClick: ((Movie) -> Unit)? = null

    fun setMovieList(context: Context, moviesList: ArrayList<Movie>){
        this.moviesList = moviesList
        this.context = context
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(MovieItemBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = moviesList[position]
        Glide.with(context)
            .load(movie.image)
            .into(holder.binding.moviePosterImg)
        holder.binding.movieTitleTv.text = movie.title
        holder.binding.movieSubtitleTv.text = "${movie.year} • ${movie.duration}"
        holder.binding.movieTypeTv.text = movie.type?.capitalize()
        holder.binding.movieDescTv.text = movie.description
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(movie)
        }
        if(movie.isPrime == true){
            holder.binding.moviePrimeIconLayout.visibility = View.VISIBLE
        }else{
            holder.binding.moviePrimeIconLayout.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    inner class MovieViewHolder(val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root)
}