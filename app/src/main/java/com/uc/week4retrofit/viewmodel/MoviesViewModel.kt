package com.uc.week4retrofit.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.week4retrofit.model.MovieDetails
import com.uc.week4retrofit.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.uc.week4retrofit.model.Result
import kotlinx.coroutines.launch


@HiltViewModel
class MoviesViewModel @Inject constructor(private val repository: MoviesRepository) : ViewModel() {

//    Ini bagian dari get now playing data
    val _nowPlaying : MutableLiveData<ArrayList<Result>> by lazy {
        MutableLiveData<ArrayList<Result>>()
    }

    val nowPlaying : LiveData<ArrayList<Result>>
    get() = _nowPlaying

    fun getNowPlaying(apiKey : String , language : String , page : Int) = viewModelScope.launch {
        repository.getNowPlayingResult(apiKey, language, page).let {
            response ->
                if(response.isSuccessful){
//                    Fungsi ? adalah untuk mengecek apakah data itu 0 atau tidak
                    _nowPlaying.postValue(response.body()?.results as
                    ArrayList<Result>?)
                } else {
                    Log.e("Get Data" , "Failed!")
                }
        }
    }


//    Ini bagian dari get movie details
//    Tidak menggunakan ArrayList karena didalam function getMovieDetails tidak menampilkan banyak data
//    Didalam function getMovieDetails hanya menampilkan 1 detail data, sehingga val _movieDetails tidak menggunakan ArrayList
//    Tetapi hanya menggunakan MovieDetails, nama MovieDetails digunakan karena MutableList mengambil data dari model MovieDetails

    val _movieDetails : MutableLiveData<MovieDetails> by lazy {
        MutableLiveData<MovieDetails>()
    }

    val movieDetails : LiveData<MovieDetails>
        get() = _movieDetails

    fun getMovieDetail (apiKey : String ,movieId : Int) = viewModelScope.launch {
        repository.getMovieDetailResults(apiKey , movieId).let {
                response ->
            if(response.isSuccessful){
//                    Fungsi ? adalah untuk mengecek apakah data itu 0 atau tidak
                _movieDetails.postValue(response.body() as MovieDetails)
            } else {
                Log.e("Get movie Details data" , "Failed!")
            }
        }
    }
}