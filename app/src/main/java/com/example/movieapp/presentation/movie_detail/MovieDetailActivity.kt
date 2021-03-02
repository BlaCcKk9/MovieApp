package com.example.movieapp.presentation.movie_detail


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.movieapp.MainActivity
import com.example.movieapp.R
import com.example.movieapp.data.models.MovieModel
import com.example.movieapp.presentation.base.BaseActivity


class MovieDetailActivity : BaseActivity<MovieDetailPresenter>(), MovieDetailView {

    private lateinit var movieModel: MovieModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        initViews()
        presenter.attach(this)
    }

    private fun initViews(){
        movieModel = intent.extras!!.getSerializable("MOVIE_MODEL") as MovieModel
        Log.e("detailName->>", movieModel.name)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        fun start(context: Context, movieModel: MovieModel) {
            context.startActivity(Intent(context, MovieDetailActivity::class.java).apply {
                putExtra("MOVIE_MODEL", movieModel)
            })
        }
    }
}