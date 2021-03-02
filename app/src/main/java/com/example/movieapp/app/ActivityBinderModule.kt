package com.example.movieapp.app

import com.example.movieapp.MainActivity
import com.example.movieapp.app.scopes.PerActivity
import com.example.movieapp.presentation.authorization.splash.SplashActivity
import com.example.movieapp.presentation.movie_detail.MovieDetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinderModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun splashActivity(): SplashActivity

    @PerActivity
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @PerActivity
    @ContributesAndroidInjector
    abstract fun movieDetailActivity(): MovieDetailActivity
}