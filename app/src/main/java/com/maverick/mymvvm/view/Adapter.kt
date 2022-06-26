package com.maverick.mymvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maverick.mymvvm.databinding.ActivityMovieItemBinding
import com.maverick.mymvvm.models.MovieModel

class Adapter : RecyclerView.Adapter<MainViewHolder>() {
    private var movie = mutableListOf<MovieModel>()

    fun setMovieList(movies: List<MovieModel>) {
        this.movie = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ActivityMovieItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movie[position]
        holder.binding.name.text = movie.name
        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)
    }

    override fun getItemCount(): Int {
        return movie.size
    }
}

class MainViewHolder(val binding: ActivityMovieItemBinding) : RecyclerView.ViewHolder(binding.root)
