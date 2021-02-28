package com.example.movieapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.movieapp.data.models.MovieModel
import com.example.movieapp.presentation.base.BaseActivity
import com.example.movieapp.presentation.main.MainPresenter
import com.example.movieapp.presentation.main.MainView
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : BaseActivity<MainPresenter>(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attach(this)
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

    override fun populatePopularMovies(movies: List<MovieModel>) {
        Log.e("moviessi->>>", movies.size.toString())
        movies.forEach {
            Log.e("ahahahaahahah->>.", it.name)
        }
    }
}