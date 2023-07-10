package com.one.visionadmin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.one.visionadmin.R
import com.one.visionadmin.databinding.ActivityMovieBinding
import com.one.visionadmin.databinding.MovieCardBinding
import com.one.visionadmin.models.Movie

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding
    private lateinit var movie: Movie
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getMovieData()
    }

    private fun getMovieData() {
        movie = intent.getParcelableExtra("MOVIE")!!
        setMovieData()
    }

    private fun setMovieData(){
        Glide.with(this)
            .load(movie.image)
            .into(binding.movieEditPosterImg)
        if(movie.isPrime == true){
            binding.moviePrimeChip.isChecked = true
        }else{
            binding.movieFreeChip.isChecked = true
        }
        binding.movieEditTitleTextField.editText?.setText(movie.title)
        binding.movieEditImgTextField.editText?.setText(movie.image)
        binding.movieEditRatingsTextField.editText?.setText(movie.rating)
        binding.movieEditYearTextField.editText?.setText(movie.year)
        binding.movieEditDurationTextField.editText?.setText(movie.duration)
        binding.movieEditDescriptionTextField.editText?.setText(movie.description)
        binding.movieEditOttPlatformTextField.editText?.setText(movie.ottPlatform)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(
            R.anim.slide_in_left,
            R.anim.slide_out_right
        )
    }
}