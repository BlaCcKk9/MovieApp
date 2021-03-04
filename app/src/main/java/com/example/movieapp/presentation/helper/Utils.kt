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

fun getRating(number: Float): Float = when (number) {
        in 0f..1f -> 0.5f
        in 1f..2f -> 1f
        in 2f..3f -> 1.5f
        in 3f..4f -> 2f
        in 4f..5f -> 2.5f
        in 5f..6f -> 3f
        in 6f..7f -> 3.5f
        in 7f..8f -> 4f
        in 8f..9f -> 4.5f
        in 9f..10f -> 5f
        else -> 0f
}