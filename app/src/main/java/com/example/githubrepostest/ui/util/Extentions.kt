package com.example.githubrepostest.ui.util

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(uri: Uri){

    Glide.with(this)
        .load(uri)
        .into(this)
}


fun ImageView.loadImage(resourceId: Int){

    Glide.with(this)
        .load(resourceId)
        .into(this)
}
