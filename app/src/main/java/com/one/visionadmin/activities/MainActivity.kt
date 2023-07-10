package com.one.visionadmin.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.forEach
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.chip.Chip
import com.one.visionadmin.models.Cast
import com.one.visionadmin.models.Episode
import com.one.visionadmin.models.Season
import com.one.visionadmin.R
import com.one.visionadmin.adapters.MoviesAdapter
import com.one.visionadmin.adapters.UsersAdapter
import com.one.visionadmin.databinding.ActivityMainBinding
import com.one.visionadmin.models.Movie
import com.one.visionadmin.models.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var usersAdapter: UsersAdapter

    private var moviesList = ArrayList<Movie>()
    private var usersList = ArrayList<User>()
    private var movieTagsList = ArrayList<String>()
    private var movieLanguagesList = ArrayList<String>()
    private var movieCastsList = ArrayList<Cast>()
    private var movieSeasonsList = ArrayList<Season>()
    private var movieEpisodesList = ArrayList<Episode>()
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        getMovieData()
        getUserData()
        changeRVData("Users")
        setHomeRV()
        onClick()
    }

    private fun init() {
        moviesAdapter = MoviesAdapter()
        usersAdapter = UsersAdapter()
    }

    private fun onClick() {
        moviesAdapter.onItemClick = { movie ->
            val intent = Intent(this@MainActivity, MovieActivity::class.java)
            intent.putExtra("MOVIE", movie)
            startActivity(intent)
            inAnimation()
        }

        usersAdapter.onItemClick = { user ->
            val intent = Intent(this@MainActivity, UserActivity::class.java)
            intent.putExtra("USER", user)
            startActivity(intent)
            inAnimation()
        }

        binding.homeChipGroup.forEach { child ->
            (child as? Chip)?.setOnCheckedChangeListener { _, _ ->
                changeRVData(child.text as String)
            }
        }
    }

    private fun getMovieData() {
        //Dummy Movie Data
        movieTagsList.apply {
            add("Comedy")
            add("Drama")
            add("Action")
        }
        movieLanguagesList.apply {
            add("English")
            add("Hindi")
        }
        movieCastsList.apply {
            add(
                Cast(
                    "Shawn Ashmore",
                    "https://m.media-amazon.com/images/M/MV5BN2VjNGRjNDctYzg4MC00OTkwLThhMmItMWZlZGFiOTQ1YTAwXkEyXkFqcGdeQXVyNDAzNDk0MTQ@._V1_.jpg"
                )
            )
            add(
                Cast(
                    "Shawn Ashmore",
                    "https://m.media-amazon.com/images/M/MV5BN2VjNGRjNDctYzg4MC00OTkwLThhMmItMWZlZGFiOTQ1YTAwXkEyXkFqcGdeQXVyNDAzNDk0MTQ@._V1_.jpg"
                )
            )
            add(
                Cast(
                    "Shawn Ashmore",
                    "https://m.media-amazon.com/images/M/MV5BN2VjNGRjNDctYzg4MC00OTkwLThhMmItMWZlZGFiOTQ1YTAwXkEyXkFqcGdeQXVyNDAzNDk0MTQ@._V1_.jpg"
                )
            )
        }
        movieEpisodesList.apply {
            add(
                Episode(
                    "1",
                    "The Legend Begins",
                    "https://img1.hotstarext.com/image/upload/f_auto/sources/r1/cms/prod/3416/893416-h",
                    "29 Jan 2021",
                    "23m"
                )
            )
            add(
                Episode(
                    "2",
                    "The Monkey King",
                    "https://img1.hotstarext.com/image/upload/f_auto/sources/r1/cms/prod/3417/893417-h",
                    "29 Jan 2021",
                    "21m"
                )
            )
            add(
                Episode(
                    "3",
                    "Kishkindha Bound",
                    "https://img1.hotstarext.com/image/upload/f_auto/sources/r1/cms/prod/3419/893419-h",
                    "29 Jan 2021",
                    "21m"
                )
            )
            add(
                Episode(
                    "4",
                    "The Promise",
                    "https://img1.hotstarext.com/image/upload/f_auto/sources/r1/cms/prod/3421/893421-h",
                    "29 Jan 2021",
                    "23m"
                )
            )
            add(
                Episode(
                    "5",
                    "The Legend Begins",
                    "https://img1.hotstarext.com/image/upload/f_auto/sources/r1/cms/prod/3416/893416-h",
                    "29 Jan 2021",
                    "23m"
                )
            )
            add(
                Episode(
                    "6",
                    "The Monkey King",
                    "https://img1.hotstarext.com/image/upload/f_auto/sources/r1/cms/prod/3417/893417-h",
                    "29 Jan 2021",
                    "21m"
                )
            )
            add(
                Episode(
                    "7",
                    "Kishkindha Bound",
                    "https://img1.hotstarext.com/image/upload/f_auto/sources/r1/cms/prod/3419/893419-h",
                    "29 Jan 2021",
                    "21m"
                )
            )
            add(
                Episode(
                    "8",
                    "The Promise",
                    "https://img1.hotstarext.com/image/upload/f_auto/sources/r1/cms/prod/3421/893421-h",
                    "29 Jan 2021",
                    "23m"
                )
            )
        }
        movieSeasonsList.apply {
            add(
                Season(
                    "Season 1",
                    movieEpisodesList
                )
            )
            add(
                Season(
                    "Season 2",
                    movieEpisodesList
                )
            )
            add(
                Season(
                    "Season 3",
                    movieEpisodesList
                )
            )
            add(
                Season(
                    "Season 4",
                    movieEpisodesList
                )
            )
            add(
                Season(
                    "Season 5",
                    movieEpisodesList
                )
            )
            add(
                Season(
                    "Season 6",
                    movieEpisodesList
                )
            )
        }
        moviesList.apply {
            add(
                Movie(
                    "0001",
                    "https://m.media-amazon.com/images/I/91A9U++FKnL._AC_SL1500_.jpg",
                    "Aftermath",
                    "4.5",
                    "2014",
                    "2h 30m",
                    movieTagsList,
                    "A young couple struggling to stay together, when they are offered an amazing deal on a home with a questionable past that would normally be beyond their means. In a final attempt to start fresh as a couple they take the deal.",
                    movieLanguagesList,
                    movieCastsList,
                    null,
                    "Disney",
                    false
                )
            )
            add(
                Movie(
                    "0001",
                    "https://m.media-amazon.com/images/I/91A9U++FKnL._AC_SL1500_.jpg",
                    "Aftermath",
                    "4.5",
                    "2014",
                    "2h 30m",
                    movieTagsList,
                    "A young couple struggling to stay together, when they are offered an amazing deal on a home with a questionable past that would normally be beyond their means. In a final attempt to start fresh as a couple they take the deal.",
                    movieLanguagesList,
                    movieCastsList,
                    null,
                    "Disney",
                    true
                )
            )
            add(
                Movie(
                    "0001",
                    "https://m.media-amazon.com/images/I/91A9U++FKnL._AC_SL1500_.jpg",
                    "Aftermath",
                    "4.5",
                    "2014",
                    "2h 30m",
                    movieTagsList,
                    "A young couple struggling to stay together, when they are offered an amazing deal on a home with a questionable past that would normally be beyond their means. In a final attempt to start fresh as a couple they take the deal.",
                    movieLanguagesList,
                    movieCastsList,
                    movieSeasonsList,
                    "Disney",
                    false
                )
            )
            add(
                Movie(
                    "0001",
                    "https://m.media-amazon.com/images/I/91A9U++FKnL._AC_SL1500_.jpg",
                    "Aftermath",
                    "4.5",
                    "2014",
                    "2h 30m",
                    movieTagsList,
                    "A young couple struggling to stay together, when they are offered an amazing deal on a home with a questionable past that would normally be beyond their means. In a final attempt to start fresh as a couple they take the deal.",
                    movieLanguagesList,
                    movieCastsList,
                    movieSeasonsList,
                    "Disney",
                    true
                )
            )
        }

        moviesAdapter.setMovieList(this, moviesList)
    }

    private fun getUserData() {
        user = User(
            "Raj Maru",
            "https://lh3.googleusercontent.com/a/AAcHTtd12_FfREgn07fQcUqCoyxij8IblTITeatLNYb1qnWNbw=s288-c-no",
            "rajmaru0304@gmail.com",
            "Yearly",
            moviesList
        )

        usersList.apply {
            add(user)
            add(user)
            add(user)
            add(user)
            add(user)
            add(user)
        }

        usersAdapter.setUserList(this, usersList)
    }


    private fun changeRVData(id: String) {
        Log.d("RAJ", id)
        if (id == "Users") {
            binding.homeRv.adapter = usersAdapter
        }
        if (id == "Movies / Series") {
            binding.homeRv.adapter = moviesAdapter
        }
    }

    private fun setHomeRV() {
        binding.homeRv.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
    }

    private fun inAnimation() {
        overridePendingTransition(
            R.anim.slide_in_right,
            R.anim.slide_out_left
        )
    }
}