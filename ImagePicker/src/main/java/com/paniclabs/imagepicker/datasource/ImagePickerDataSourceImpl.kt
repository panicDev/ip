package com.paniclabs.imagepicker.datasource

import android.net.Uri
import com.paniclabs.imagepicker.IPConfig
import com.paniclabs.imagepicker.ui.album.model.AlbumMenuViewData
import com.paniclabs.imagepicker.ui.album.model.AlbumViewData
import com.paniclabs.imagepicker.ui.detail.model.DetailImageViewData
import com.paniclabs.imagepicker.ui.picker.model.PickerMenuViewData
import com.paniclabs.imagepicker.ui.picker.model.PickerViewData

class ImagePickerDataSourceImpl(private val ipConfig: IPConfig) : ImagePickerDataSource {
    override fun getSelectedImageList(): List<Uri> = ipConfig.selectedImages

    override fun getPickerImages(): List<Uri> = ipConfig.currentPickerImageList

    override fun getMaxCount() = ipConfig.maxCount
    override fun getMinCount() = ipConfig.minCount

    override fun getIsAutomaticClose(): Boolean = ipConfig.isAutomaticClose

    override fun getMessageLimitReached() = ipConfig.messageLimitReached
    override fun getMessageNothingSelected() = ipConfig.messageNothingSelected

    override fun getExceptMimeTypeList() = ipConfig.exceptMimeTypeList
    override fun getSpecifyFolderList() = ipConfig.specifyFolderList
    override fun getAllViewTitle() = ipConfig.titleAlbumAllView
    override fun getImageAdapter() = ipConfig.imageAdapter

    override fun selectImage(imageUri: Uri) {
        ipConfig.selectedImages.add(imageUri)
    }

    override fun unselectImage(imageUri: Uri) {
        ipConfig.selectedImages.remove(imageUri)
    }

    override fun getDetailViewData() = DetailImageViewData(
        ipConfig.colorStatusBar,
        ipConfig.isStatusBarLight,
        ipConfig.colorActionBar,
        ipConfig.colorActionBarTitle,
        ipConfig.colorSelectCircleStroke
    )

    override fun getAlbumViewData() = AlbumViewData(
        ipConfig.colorStatusBar,
        ipConfig.isStatusBarLight,
        ipConfig.colorActionBar,
        ipConfig.colorActionBarTitle,
        ipConfig.titleActionBar,
        ipConfig.drawableHomeAsUpIndicator,
        ipConfig.albumPortraitSpanCount,
        ipConfig.albumLandscapeSpanCount,
        ipConfig.albumThumbnailSize,
        ipConfig.maxCount,
        ipConfig.isShowCount
    )

    override fun gatAlbumMenuViewData() = AlbumMenuViewData(
        ipConfig.hasButtonInAlbumActivity,
        ipConfig.drawableDoneButton,
        ipConfig.strDoneMenu,
        ipConfig.colorTextMenu
    )

    override fun getPickerViewData() = PickerViewData(
        ipConfig.colorStatusBar,
        ipConfig.isStatusBarLight,
        ipConfig.colorActionBar,
        ipConfig.colorActionBarTitle,
        ipConfig.titleActionBar,
        ipConfig.drawableHomeAsUpIndicator,
        ipConfig.albumPortraitSpanCount,
        ipConfig.albumLandscapeSpanCount,
        ipConfig.albumThumbnailSize,
        ipConfig.maxCount,
        ipConfig.isShowCount,
        ipConfig.colorSelectCircleStroke,
        ipConfig.isAutomaticClose,
        ipConfig.photoSpanCount
    )

    override fun setCurrentPickerImageList(pickerImageList: List<Uri>) {
        ipConfig.currentPickerImageList = pickerImageList
    }

    override fun hasCameraInPickerPage() = ipConfig.hasCameraInPickerPage
    override fun useDetailView() = ipConfig.isUseDetailView
    override fun getPickerMenuViewData() = PickerMenuViewData(
        ipConfig.drawableDoneButton,
        ipConfig.drawableAllDoneButton,
        ipConfig.strDoneMenu,
        ipConfig.colorTextMenu,
        ipConfig.strAllDoneMenu,
        ipConfig.isUseAllDoneButton
    )

    override fun isStartInAllView() = ipConfig.isStartInAllView

    override fun getIsAutomaticRunCamera(): Boolean = ipConfig.isAutomaticRunningCamera
}
