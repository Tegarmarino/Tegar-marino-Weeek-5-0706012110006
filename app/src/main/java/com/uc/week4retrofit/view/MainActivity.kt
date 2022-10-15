package com.uc.week4retrofit.view

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.uc.week4retrofit.adapter.NowPlayingAdapter
import com.uc.week4retrofit.databinding.ActivityMainBinding
import com.uc.week4retrofit.helper.Const
import com.uc.week4retrofit.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

// AndroidEntryPoint berfungsi untuk menarik modul modul yg ada di ViewModel
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptery : NowPlayingAdapter
    private lateinit var viewModel : MoviesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Inisalisasi binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Perintah untuk menyembunyikan Project name atau Action Bar
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        viewModel.getNowPlaying(Const.API_KEY, "en-US", 1)

        viewModel.nowPlaying.observe(this , Observer { response->
            binding.rvMain.layoutManager = LinearLayoutManager(this)
            adaptery = NowPlayingAdapter(response)
            binding.rvMain.adapter = adaptery
        })
    }
}