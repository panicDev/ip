package com.paniclabs.imagepicker.datasource

import android.net.Uri
import com.paniclabs.imagepicker.MimeType
import com.paniclabs.imagepicker.adapter.image.ImageAdapter
import com.paniclabs.imagepicker.ui.album.model.AlbumMenuViewData
import com.paniclabs.imagepicker.ui.album.model.AlbumViewData
import com.paniclabs.imagepicker.ui.detail.model.DetailImageViewData
import com.paniclabs.imagepicker.ui.picker.model.PickerMenuViewData
import com.paniclabs.imagepicker.ui.picker.model.PickerViewData

interface ImagePickerDataSource {
    fun getSelectedImageList(): List<Uri>
    fun selectImage(imageUri: Uri)
    fun unselectImage(imageUri: Uri)
    fun getPickerImages(): List<Uri>
    fun getMaxCount(): Int
    fun getMinCount(): Int
    fun getIsAutomaticClose(): Boolean
    fun getMessageLimitReached(): String
    fun getMessageNothingSelected(): String
    fun getExceptMimeTypeList(): List<MimeType>
    fun getSpecifyFolderList(): List<String>
    fun getAllViewTitle(): String
    fun getDetailViewData(): DetailImageViewData
    fun getAlbumViewData(): AlbumViewData
    fun getImageAdapter(): ImageAdapter
    fun gatAlbumMenuViewData(): AlbumMenuViewData
    fun getPickerViewData(): PickerViewData
    fun setCurrentPickerImageList(pickerImageList: List<Uri>)
    fun hasCameraInPickerPage(): Boolean
    fun useDetailView(): Boolean
    fun getPickerMenuViewData(): PickerMenuViewData
    fun isStartInAllView(): Boolean
    fun getIsAutomaticRunCamera(): Boolean
}
