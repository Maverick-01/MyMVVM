package com.maverick.mymvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maverick.mymvvm.models.MainRepository
import com.maverick.mymvvm.models.MovieModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel(private val repository: MainRepository) : ViewModel() {
    val movieList = MutableLiveData<List<MovieModel>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies() {
        val response = repository.getAllMovies()
        response.enqueue(object : Callback<List<MovieModel>> {
            override fun onResponse(call: Call<List<MovieModel>>, response: Response<List<MovieModel>>) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<MovieModel>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}