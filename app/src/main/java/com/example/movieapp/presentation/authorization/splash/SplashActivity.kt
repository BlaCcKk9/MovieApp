package com.example.movieapp.presentation.authorization.splash

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.MainActivity
import com.example.movieapp.R
import com.example.movieapp.presentation.base.BaseActivity

class SplashActivity : BaseActivity<SplashPresenter>(), SplashView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        presenter.attach(this)
    }

    override fun openMain() {
        MainActivity.start(this)
        finish()
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, SplashActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            })
        }
    }
}