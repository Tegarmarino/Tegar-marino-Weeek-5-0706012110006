package com.uc.week4retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.uc.week4retrofit.adapter.*
//import com.uc.week4retrofit.company
import com.uc.week4retrofit.databinding.ActivityMovieDetailBinding
import com.uc.week4retrofit.helper.Const
import com.uc.week4retrofit.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetail : AppCompatActivity() {

//    Menambahkan binding untuk masing - masing activity
    private lateinit var binding : ActivityMovieDetailBinding
    private lateinit var viewModel: MoviesViewModel
    private lateinit var adapter1 : GenreAdapter
    private lateinit var adapter2 : CompanyAdapter
    private lateinit var adapter3 : SpokenLangguageAdapter
    private lateinit var adapter4 : CountryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Perintah untuk menyembunyikan Project name atau Action Bar
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

//        Mengambil data movie_id dari NowPlayingAdapter
        val movieId = intent.getIntExtra("movie_id", 0)
        Toast.makeText(applicationContext, "Movie ID : ${movieId}", Toast.LENGTH_SHORT).show()

        viewModel = ViewModelProvider(this)[MoviesViewModel::class.java]
        viewModel.getMovieDetail(Const.API_KEY , movieId)
        viewModel.movieDetails.observe(this , Observer{
            response ->

            if(response != null){
                binding.mdProgressBar.visibility = View.INVISIBLE
            }
            binding.tvTitleMovieDetail.apply {
                text = response.title

                binding.rvGenre
                binding.rvGenre.layoutManager = LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL , false)
                adapter1 = GenreAdapter(response.genres)
                binding.rvGenre.adapter = adapter1

                binding.rvCompany
                binding.rvCompany.layoutManager = LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL , false)
                adapter2 = CompanyAdapter(response.production_companies)
                binding.rvCompany.adapter = adapter2

                binding.rvSpokenLangguage
                binding.rvSpokenLangguage.layoutManager = LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL , false)
                adapter3 = SpokenLangguageAdapter(response.spoken_languages)
                binding.rvSpokenLangguage.adapter = adapter3

                binding.rvCountry
                binding.rvCountry.layoutManager = LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL , false)
                adapter4 = CountryAdapter(response.production_countries)
                binding.rvCountry.adapter = adapter4

            }
//            Membuat binding baru untuk text view dengan id tv_overview. Yg digunakan untuk menampilkan overview
            binding.tvOverview.apply {
                text = response.overview
            }

//            Perintah ini digunakan untuk menampilkan image
            Glide.with(applicationContext)
                .load(Const.IMG_URL + response.backdrop_path)
                .into(binding.imgPosterMovieDetail)


        })
    }

}