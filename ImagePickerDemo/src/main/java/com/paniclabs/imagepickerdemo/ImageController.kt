package com.paniclabs.imagepickerdemo

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions

class ImageController(private val imgMain: ImageView) {

    fun setImgMain(path: Uri) {
        val options = RequestOptions().apply {
            centerCrop()
            format(DecodeFormat.PREFER_RGB_565)
        }
        Glide.with(imgMain.context)
            .load(path)
            .apply(options)
            .thumbnail(0.1f)
            .into(imgMain)
    }
}
