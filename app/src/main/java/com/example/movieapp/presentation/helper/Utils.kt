package com.example.movieapp.presentation.helper

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.ContextThemeWrapper
import com.example.movieapp.R

fun showSimpleDialog(
    activity: Context,
    message: String,
    listener: DialogInterface.OnClickListener? = null,
    title: String? = null,
    dismissListener: DialogInterface.OnDismissListener? = null
) {
    val builder = AlertDialog.Builder(ContextThemeWrapper(activity, R.style.AlertDialogStyle))
        .setMessage(message)
        .setPositiveButton("OK", listener)
        .setOnDismissListener(dismissListener)
    title?.let { builder.setTitle(it) }
    builder.show()
}