package com.paniclabs.imagepicker

import android.graphics.drawable.Drawable

interface CustomizationProperty {
    fun setAlbumThumbnailSize(size: Int): ImagePickerCreator

    fun setPickerSpanCount(spanCount: Int): ImagePickerCreator

    fun setActionBarColor(actionbarColor: Int): ImagePickerCreator

    fun setActionBarTitleColor(actionbarTitleColor: Int): ImagePickerCreator

    fun setActionBarColor(actionbarColor: Int, statusBarColor: Int): ImagePickerCreator

    fun setActionBarColor(actionbarColor: Int, statusBarColor: Int, isStatusBarLight: Boolean): ImagePickerCreator

    fun setCamera(isCamera: Boolean): ImagePickerCreator

    fun textOnNothingSelected(message: String): ImagePickerCreator

    fun textOnImagesSelectionLimitReached(message: String): ImagePickerCreator

    fun setButtonInAlbumActivity(isButton: Boolean): ImagePickerCreator

    fun setAlbumSpanCount(portraitSpanCount: Int, landscapeSpanCount: Int): ImagePickerCreator

    fun setAlbumSpanCountOnlyLandscape(landscapeSpanCount: Int): ImagePickerCreator

    fun setAlbumSpanCountOnlPortrait(portraitSpanCount: Int): ImagePickerCreator

    fun setAllViewTitle(allViewTitle: String): ImagePickerCreator

    fun setActionBarTitle(actionBarTitle: String): ImagePickerCreator

    fun setHomeAsUpIndicatorDrawable(icon: Drawable?): ImagePickerCreator

    fun setDoneButtonDrawable(icon: Drawable?): ImagePickerCreator

    fun setAllDoneButtonDrawable(icon: Drawable?): ImagePickerCreator

    fun setIsUseAllDoneButton(isUse: Boolean): ImagePickerCreator

    fun setMenuDoneText(text: String?): ImagePickerCreator

    fun setMenuAllDoneText(text: String?): ImagePickerCreator

    fun setMenuTextColor(color: Int): ImagePickerCreator

    fun setIsUseDetailView(isUse: Boolean): ImagePickerCreator

    fun setIsShowCount(isShow: Boolean): ImagePickerCreator

    fun setSelectCircleStrokeColor(strokeColor: Int): ImagePickerCreator

    fun isStartInAllView(isStartInAllView: Boolean): ImagePickerCreator

    fun pickCameraOnly(isAutomaticRunningCamera: Boolean): ImagePickerCreator

    fun setSpecifyFolderList(specifyFolderList: List<String>): ImagePickerCreator

    fun hasCameraInPickerPage(hasCamera: Boolean): ImagePickerCreator
}
