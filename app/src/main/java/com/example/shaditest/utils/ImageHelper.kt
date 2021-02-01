package com.example.deevideos.utils

import android.widget.ImageView
import coil.api.load
import coil.transform.RoundedCornersTransformation


fun ImageView.loadImage(url:String?){
  if(url.isNullOrEmpty()) return
    this.load(url) {
        crossfade(true)
        crossfade(500)
        transformations(RoundedCornersTransformation(5f))
    }
}
