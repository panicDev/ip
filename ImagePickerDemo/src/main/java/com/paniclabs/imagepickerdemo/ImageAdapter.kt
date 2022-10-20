package com.paniclabs.imagepickerdemo

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.paniclabs.imagepickerdemo.databinding.ItemBinding

class ImageAdapter(
    private val context: Context,
    private val imageController: ImageController,
    private var imagePaths: List<Uri> = emptyList()
) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemBinding.inflate(LayoutInflater.from(context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imagePath = imagePaths[position]

        val options = RequestOptions().apply {
            centerCrop()
            format(DecodeFormat.PREFER_RGB_565)
        }
        Glide.with(context)
            .load(imagePath)
            .apply(options)
            .into(holder.imageView)

        holder.imageView.setOnClickListener { imageController.setImgMain(imagePath) }
    }

    fun changePath(imagePaths: ArrayList<Uri>) {
        this.imagePaths = imagePaths
        imageController.setImgMain(imagePaths[0])
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = imagePaths.size

    class ViewHolder(binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val imageView = binding.imgItem
    }
}
