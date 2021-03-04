package com.example.movieapp.presentation.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movieapp.R
import com.example.movieapp.app.IMAGE_URL
import com.example.movieapp.data.models.MovieModel
import com.example.movieapp.presentation.helper.getRating
import kotlinx.android.synthetic.main.item_popular_movie.view.*

class PopularMoviesAdapter(
    private val onItemClicked: (MovieModel) -> Unit,
): RecyclerView.Adapter<PopularMoviesAdapter.PopularMoviesViewHolder>() {

    private val popularMovies = mutableListOf<MovieModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesAdapter.PopularMoviesViewHolder =
        PopularMoviesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_popular_movie, parent, false))

    override fun onBindViewHolder(holder: PopularMoviesAdapter.PopularMoviesViewHolder, position: Int) {

        var movie = popularMovies[position]

        holder.itemView.apply {
            tvName.text = movie.name
            tvDate.text = movie.date
            tvLanguage.text = movie.language
            ratingBar.rating = getRating(movie.voteAverage.toFloat())
            Glide.with(context).asBitmap().load(IMAGE_URL + movie.image).into(ivImage)

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