package com.example.movieapp.presentation.base

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.movieapp.presentation.helper.showSimpleDialog
import dagger.android.AndroidInjection
import javax.inject.Inject

@SuppressLint("Registered")
open class BaseActivity<T : BasePresenter<out BaseView>> : AppCompatActivity() {

    @field:Inject
    lateinit var presenter: T

    var isErrorShown = false

    private val dismissListener = DialogInterface.OnDismissListener { isErrorShown = false }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

    fun showMessage(messageId: Int, titleId: Int?) {
        if (isErrorShown)
            return
        else isErrorShown = true
        val title = if (titleId != null) getString(titleId) else null
        showSimpleDialog(
            this,
            getString(messageId),
            title = title,
            dismissListener = dismissListener
        )
    }

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}