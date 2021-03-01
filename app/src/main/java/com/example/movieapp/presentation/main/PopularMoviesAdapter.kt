package com.example.movieapp.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.data.models.MovieModel
import kotlinx.android.synthetic.main.item_popular_movie.view.*

class PopularMoviesAdapter(
    private val onItemClicked: (MovieModel) -> Unit
): RecyclerView.Adapter<PopularMoviesAdapter.PopularMoviesViewHolder>() {

    private val popularMovies = mutableListOf<MovieModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesAdapter.PopularMoviesViewHolder =
        PopularMoviesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_popular_movie, parent, false))

    override fun onBindViewHolder(holder: PopularMoviesAdapter.PopularMoviesViewHolder, position: Int) {
        holder.itemView.apply {
            tvName.text = popularMovies[position].name
        }
    }

    fun setItems(items: List<MovieModel>) {
        popularMovies.clear()
        popularMovies.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = popularMovies.size


    inner class PopularMoviesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener {
                onItemClicked.invoke(popularMovies[adapterPosition])
            }
        }
    }
}