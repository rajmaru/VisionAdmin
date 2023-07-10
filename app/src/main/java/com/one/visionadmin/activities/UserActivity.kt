package com.one.visionadmin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.one.visionadmin.models.Cast
import com.one.visionadmin.models.Episode
import com.one.visionadmin.models.Season
import com.one.visionadmin.R
import com.one.visionadmin.adapters.WatchListAdapter
import com.one.visionadmin.databinding.ActivityUserBinding
import com.one.visionadmin.itemdecoration.UserWatchListDecoration
import com.one.visionadmin.models.Movie
import com.one.visionadmin.models.User

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding
    private lateinit var user: User
    private lateinit var watchListAdapter: WatchListAdapter
    private lateinit var userWatchListDecoration: UserWatchListDecoration

    private var moviesList = ArrayList<Movie>()
    private var movieTagsList = ArrayList<String>()
    private var movieLanguagesList = ArrayList<String>()
    private var movieCastsList = ArrayList<Cast>()
    private var movieSeasonsList = ArrayList<Season>()
    private var movieEpisodesList = ArrayList<Episode>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        onClick()
        getUserData()
        getWatchListData()
    }

    private fun init(){
        watchListAdapter = WatchListAdapter()
        userWatchListDecoration = UserWatchListDecoration()
    }

    private fun getUserData() {
        user = intent.getParcelableExtra("USER")!!
        setUserData()
    }

    private fun setUserData() {
        Glide.with(this)
            .load(user.img)
            .into(binding.userProfilePic)
        binding.userNameTv.text = user.name
        binding.userEmailTv.text = user.email
        setPlanDetails(user.plan!!)
    }

    private fun setPlanDetails(plan: String) {
        if (plan == "Free") {
            binding.userCurrentPlanTv.text = plan
            binding.userFreeMoviesTick.setColorFilter(this.resources.getColor(R.color.active_icon_tick))
        }
        if (plan == "Monthly") {
            binding.userCurrentPlanTv.text = plan
            binding.userFreeMoviesTick.setColorFilter(this.resources.getColor(R.color.active_icon_tick))
            binding.userLiveTvTick.setColorFilter(this.resources.getColor(R.color.active_icon_tick))
            binding.userPrimeMoviesTick.setColorFilter(this.resources.getColor(R.color.active_icon_tick))
        }
        if (plan == "Yearly") {
            binding.userCurrentPlanTv.text = plan
            binding.userFreeMoviesTick.setColorFilter(this.resources.getColor(R.color.active_icon_tick))
            binding.userLiveTvTick.setColorFilter(this.resources.getColor(R.color.active_icon_tick))
            binding.userPrimeMoviesTick.setColorFilter(this.resources.getColor(R.color.active_icon_tick))
            binding.userRequestMoviesTick.setColorFilter(this.resources.getColor(R.color.active_icon_tick))

        }
    }

    private fun getWatchListData() {
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

        setWatchListdata()
    }

    private fun setWatchListdata(){
        watchListAdapter.setMovieList(this, moviesList)
        binding.userWatchlistRv.apply {
            addItemDecoration(userWatchListDecoration)
            adapter = watchListAdapter
            layoutManager = LinearLayoutManager(this@UserActivity, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun onClick(){
        binding.userBackButton.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(
            R.anim.slide_in_left,
            R.anim.slide_out_right
        )
    }
}