package com.uc.week4retrofit.helper

// Membuat object untuk konstanta yg berisi variable - variable Global
object Const {
//    Data const val diambil dari TMDB yg diambil dari postman UC - DB Movie / Get Upcoming
//    Mengapa kita copy https://api.themoviedb.org/3/ mengapa tidak full URL, dikarenakan kita hanya akses base URL nya saja
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val API_KEY = "ce25aa7b809b26c8a9d9407ff068668f"
    const val IMG_URL = "https://image.tmdb.org/t/p/w500/"
}