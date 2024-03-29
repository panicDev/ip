package com.paniclabs.imagepicker.adapter.image.impl

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.paniclabs.imagepicker.adapter.image.ImageAdapter

class GlideAdapter : ImageAdapter {
    override fun loadImage(target: ImageView, loadUrl: Uri) {
        val options = RequestOptions().apply {
            centerCrop()
            format(DecodeFormat.PREFER_RGB_565)
        }

        Glide
            .with(target.context)
            .load(loadUrl)
            .apply(options)
            .override(target.width, target.height)
            .thumbnail(0.1f)
            .into(target)
    }

    override fun loadDetailImage(target: ImageView, loadUrl: Uri) {
        val options = RequestOptions().fitCenter()
        Glide
            .with(target.context)
            .load(loadUrl)
            .apply(options)
            .into(target)
    }
}
