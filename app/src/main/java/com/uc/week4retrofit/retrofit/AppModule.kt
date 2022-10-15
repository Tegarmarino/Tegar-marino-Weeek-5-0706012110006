package com.uc.week4retrofit.retrofit

// Didalam appmodule ini dia akan generate data dari API

//Menggunakan library dari dagger
import com.uc.week4retrofit.helper.Const
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// Kegunaan dagger adalah mempercepat penulisan fungsi, sehingga tidak perlu menuliskan fungsi yg berulang - ulang
@Module
//Kegunaan menggunakan SingletonComponent adalah
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getRetrofitServiceInstance(retrofit: Retrofit) : EndPointApi {
        return retrofit.create(EndPointApi::class.java)
    }

    @Singleton
    @Provides
//    Fun pada getRetrofit tidak boleh sama
    fun getRetrofitInstance() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}