package com.paniclabs.imagepicker.ui.detail.model

import android.net.Uri
import com.paniclabs.imagepicker.datasource.ImagePickerDataSource

class DetailImageRepositoryImpl(private val imagePickerDataSource: ImagePickerDataSource) :
    DetailImageRepository {
    override fun getPickerImage(index: Int) = imagePickerDataSource.getPickerImages().getOrNull(index)

    override fun getPickerImages(): List<Uri> = imagePickerDataSource.getPickerImages()

    override fun isSelected(imageUri: Uri) =
        imagePickerDataSource.getSelectedImageList().contains(imageUri)

    override fun getImageIndex(imageUri: Uri) =
        imagePickerDataSource.getSelectedImageList().indexOf(imageUri)


    override fun selectImage(imageUri: Uri) {
        imagePickerDataSource.selectImage(imageUri)
    }

    override fun unselectImage(imageUri: Uri) {
        imagePickerDataSource.unselectImage(imageUri)
    }

    override fun getImageAdapter() = imagePickerDataSource.getImageAdapter()

    override fun isFullSelected(): Boolean =
        imagePickerDataSource.getSelectedImageList().size == imagePickerDataSource.getMaxCount()

    override fun checkForFinish(): Boolean =
        imagePickerDataSource.getIsAutomaticClose() && isFullSelected()

    override fun getMessageLimitReached() = imagePickerDataSource.getMessageLimitReached()
    override fun getMaxCount() = imagePickerDataSource.getMaxCount()

    override fun getDetailPickerViewData() = imagePickerDataSource.getDetailViewData()
}
