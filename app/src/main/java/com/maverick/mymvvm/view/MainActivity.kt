package com.maverick.mymvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.maverick.mymvvm.R
import com.maverick.mymvvm.databinding.ActivityMainBinding
import com.maverick.mymvvm.models.MainRepository
import com.maverick.mymvvm.models.RetrofitService
import com.maverick.mymvvm.viewmodel.MainViewModel
import com.maverick.mymvvm.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofit = RetrofitService.getRetrofitInstance()
    val adapter = Adapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this,ViewModelFactory(MainRepository(retrofit))).get(MainViewModel::class.java)
        binding.recyclerview.adapter = adapter

        viewModel.movieList.observe(this, Observer {
            adapter.setMovieList(it)
        })

        viewModel.errorMessage.observe(this, Observer {

        })
        viewModel.getAllMovies()
    }
}