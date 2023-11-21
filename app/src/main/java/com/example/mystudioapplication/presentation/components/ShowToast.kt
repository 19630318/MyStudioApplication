package com.example.mystudioapplication.presentation.components

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

fun showToast(context: Context, @StringRes messageResId: Int) {
    Toast.makeText(context, context.getString(messageResId), Toast.LENGTH_SHORT).show()
}

@Composable
fun showToastRegister(context: Context, @StringRes messageResId: Int) {
    LaunchedEffect(key1 = messageResId) {
        if (messageResId != 0) {
            val message = context.getString(messageResId)
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }
}
