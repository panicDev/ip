package com.paniclabs.imagepicker

import android.content.Intent
import android.net.Uri
import androidx.activity.result.ActivityResultLauncher

interface BaseProperty {
    fun setSelectedImages(selectedImages: ArrayList<Uri>): ImagePickerCreator

    fun setPickerCount(count: Int): ImagePickerCreator

    fun setMaxCount(count: Int): ImagePickerCreator

    fun setMinCount(count: Int): ImagePickerCreator

    fun setRequestCode(requestCode: Int): ImagePickerCreator

    fun setReachLimitAutomaticClose(isAutomaticClose: Boolean): ImagePickerCreator

    fun exceptGif(isExcept: Boolean): ImagePickerCreator

    fun exceptMimeType(exceptMimeTypeList: List<MimeType>): ImagePickerCreator

    fun startAlbum()

    fun startAlbumWithOnActivityResult(requestCode: Int)

    fun startAlbumWithActivityResultCallback(activityResultLauncher: ActivityResultLauncher<Intent>)
}
