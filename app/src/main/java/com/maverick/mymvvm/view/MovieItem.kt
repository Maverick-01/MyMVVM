package com.maverick.mymvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maverick.mymvvm.R

class MovieItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_item)
    }
}