package com.example.movieapp.presentation.movie_detail


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.app.BACKDROP_URL
import com.example.movieapp.app.IMAGE_URL
import com.example.movieapp.data.models.MovieModel
import com.example.movieapp.presentation.base.BaseActivity
import com.example.movieapp.presentation.helper.getRating
import com.example.movieapp.presentation.main.PopularMoviesAdapter
import kotlinx.android.synthetic.main.activity_movie_detail.*


@Suppress("DEPRECATION")
class MovieDetailActivity : BaseActivity<MovieDetailPresenter>(), MovieDetailView {

    private lateinit var movieModel: MovieModel


    private val similarMoviesAdapter = SimilarMoviesAdapter {
        start(this@MovieDetailActivity, it)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        showBackButton()
        initViews()
        presenter.attach(this)
        presenter.getSimilarMovies(movieModel.id)
    }

    private fun initViews() {
        movieModel = intent.extras!!.getSerializable("MOVIE_MODEL") as MovieModel

        rvSimilarMovies.layoutManager = LinearLayoutManager(this,  LinearLayoutManager.HORIZONTAL, false)
        rvSimilarMovies.adapter = similarMoviesAdapter

        movieModel.apply {
            tvName.text = this.name
            tvDate.text = this.date
            tvLanguage.text = this.language
            tvDescription.text = this.description
            ratingBar.rating = getRating(this.voteAverage.toFloat())
            Glide.with(baseContext).asBitmap().load(BACKDROP_URL + this.background).into(ivMovieImage)
        }
    }

    private fun showBackButton() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.title = Html.fromHtml("<font color='#02d1d1'>Movie Detail</font>");
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

    override fun populateSimilarMovies(movies: List<MovieModel>) {
        similarMoviesAdapter.setItems(movies)
    }
}