package com.example.movieapp.presentation.authorization.splash

import com.example.movieapp.app.scopes.PerActivity
import com.example.movieapp.presentation.base.BasePresenter
import javax.inject.Inject

@PerActivity
class SplashPresenter @Inject constructor() : BasePresenter<SplashView>() {

    override fun onFirstAttach() {
        super.onFirstAttach()
        view?.openMain()
    }
}