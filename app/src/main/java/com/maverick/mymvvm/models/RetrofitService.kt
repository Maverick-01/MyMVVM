package com.maverick.mymvvm.models

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("movielist.json")
    fun getAllMovies(): Call<List<MovieModel>>

    companion object{
        var retrofitService :RetrofitService?=null
        fun getRetrofitInstance():RetrofitService{
            if (retrofitService==null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}