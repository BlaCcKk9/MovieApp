package com.example.movieapp.presentation.movie_detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.app.IMAGE_URL
import com.example.movieapp.data.models.MovieModel
import kotlinx.android.synthetic.main.item_similar_movie.view.*

class SimilarMoviesAdapter (
    private val onItemClicked: (MovieModel) -> Unit,
): RecyclerView.Adapter<SimilarMoviesAdapter.SimilarMoviesViewHolder>() {

    private val similarMoves = mutableListOf<MovieModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarMoviesAdapter.SimilarMoviesViewHolder =
        SimilarMoviesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_similar_movie, parent, false))

    override fun onBindViewHolder(holder: SimilarMoviesAdapter.SimilarMoviesViewHolder, position: Int) {

        var movie = similarMoves[position]

        holder.itemView.apply {
            tvName.text = movie.name
            Glide.with(context).asBitmap().load(IMAGE_URL + movie.image).into(ivImage)
        }
    }

    fun setItems(items: List<MovieModel>) {
        similarMoves.clear()
        similarMoves.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = similarMoves.size


    inner class SimilarMoviesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener {
                onItemClicked.invoke(similarMoves[adapterPosition])
            }
        }
    }
}