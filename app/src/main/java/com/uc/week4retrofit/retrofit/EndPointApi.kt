package com.uc.week4retrofit.retrofit

import com.uc.week4retrofit.model.NowPlaying
import com.uc.week4retrofit.view.MovieDetail
import com.uc.week4retrofit.model.MovieDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface EndPointApi {

//    Suspend fun untuk sebuah fungsi yg futuristic, untuk proses yg asincronus
//    Response adalah kembalian data yaitu NowPlaying

//    Get adalah saya satu fungsi dari retrofit
//    Penulisan movie/now_playing sangat sensitif, jadi harus teliti
    @GET ("movie/now_playing")
    suspend fun getNowPlaying(

//    Menambahkan Query sebagai parameter dari API yg berasal dari website themoviewdb.org bagian Now Playing, Query berfungsi untuk mengambil data dari API
        @Query("api_key") apiKey : String ,
        @Query("language") language : String ,
        @Query("page") page : Int ,
    ):Response<NowPlaying>

    @GET("movie/{id}")
    suspend fun getMovieDetails(
//        Ketika membuat path dan Query, Urutan untuk membuatnya harus Path dulu baru Query
        @Path("id") id : Int ,
//        Path menerima data dari repository suspend fun getMovieDetailResults
        @Query("api_key") apiKey: String
    ):Response<MovieDetails>

//    Membuat program untuk mengakses movie detail
}