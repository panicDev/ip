package com.paniclabs.imagepicker

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import com.paniclabs.imagepicker.ui.album.ui.AlbumActivity
import com.paniclabs.imagepicker.ui.picker.PickerActivity


class ImagePickerCreator(private val imagePicker: ImagePicker, private val config: IPConfig) : BaseProperty,
    CustomizationProperty {
    private var requestCode = ImagePicker.IMAGE_PICKER_REQUEST_CODE

    override fun setSelectedImages(selectedImages: ArrayList<Uri>): ImagePickerCreator = this.apply {
        config.selectedImages.addAll(selectedImages)
    }

    override fun setAlbumThumbnailSize(size: Int): ImagePickerCreator = apply {
        config.albumThumbnailSize = size
    }

    override fun setPickerSpanCount(spanCount: Int): ImagePickerCreator = this.apply {
        config.photoSpanCount = if (spanCount <= 0) 3 else spanCount
    }

    @Deprecated("instead setMaxCount(count)", ReplaceWith("setMaxCount(count)"))
    override fun setPickerCount(count: Int): ImagePickerCreator = this.apply {
        setMaxCount(count)
    }

    override fun setMaxCount(count: Int): ImagePickerCreator = this.apply {
        config.maxCount = if (count <= 0) 1 else count
    }

    override fun setMinCount(count: Int): ImagePickerCreator = this.apply {
        config.minCount = if (count <= 0) 1 else count
    }

    override fun setActionBarTitleColor(actionbarTitleColor: Int): ImagePickerCreator = this.apply {
        config.colorActionBarTitle = actionbarTitleColor
    }

    override fun setActionBarColor(actionbarColor: Int): ImagePickerCreator = this.apply {
        config.colorActionBar = actionbarColor
    }

    override fun setActionBarColor(actionbarColor: Int, statusBarColor: Int): ImagePickerCreator =
        this.apply {
            config.colorActionBar = actionbarColor
            config.colorStatusBar = statusBarColor
        }

    override fun setActionBarColor(
        actionbarColor: Int,
        statusBarColor: Int,
        isStatusBarLight: Boolean
    ): ImagePickerCreator = this.apply {
        config.colorActionBar = actionbarColor
        config.colorStatusBar = statusBarColor
        config.isStatusBarLight = isStatusBarLight
    }

    @Deprecated("instead setCamera(count)", ReplaceWith("hasCameraInPickerPage(mimeType)"))
    override fun setCamera(isCamera: Boolean): ImagePickerCreator = this.apply {
        config.hasCameraInPickerPage = isCamera
    }

    override fun hasCameraInPickerPage(hasCamera: Boolean): ImagePickerCreator = this.apply {
        config.hasCameraInPickerPage = hasCamera
    }

    @Deprecated("To be deleted along with the startAlbum function")
    override fun setRequestCode(requestCode: Int): ImagePickerCreator = this.apply {
        this.requestCode = requestCode
    }

    override fun textOnNothingSelected(message: String): ImagePickerCreator = this.apply {
        config.messageNothingSelected = message
    }

    override fun textOnImagesSelectionLimitReached(message: String): ImagePickerCreator = this.apply {
        config.messageLimitReached = message
    }

    override fun setButtonInAlbumActivity(isButton: Boolean): ImagePickerCreator = this.apply {
        config.hasButtonInAlbumActivity = isButton
    }

    override fun setReachLimitAutomaticClose(isAutomaticClose: Boolean): ImagePickerCreator =
        this.apply {
            config.isAutomaticClose = isAutomaticClose
        }

    override fun setAlbumSpanCount(
        portraitSpanCount: Int,
        landscapeSpanCount: Int
    ): ImagePickerCreator = this.apply {
        config.albumPortraitSpanCount = portraitSpanCount
        config.albumLandscapeSpanCount = landscapeSpanCount
    }

    override fun setAlbumSpanCountOnlyLandscape(landscapeSpanCount: Int): ImagePickerCreator =
        this.apply {
            config.albumLandscapeSpanCount = landscapeSpanCount
        }

    override fun setAlbumSpanCountOnlPortrait(portraitSpanCount: Int): ImagePickerCreator = this.apply {
        config.albumPortraitSpanCount = portraitSpanCount
    }

    override fun setAllViewTitle(allViewTitle: String): ImagePickerCreator = this.apply {
        config.titleAlbumAllView = allViewTitle
    }

    override fun setActionBarTitle(actionBarTitle: String): ImagePickerCreator = this.apply {
        config.titleActionBar = actionBarTitle
    }

    override fun setHomeAsUpIndicatorDrawable(icon: Drawable?): ImagePickerCreator = this.apply {
        config.drawableHomeAsUpIndicator = icon
    }

    override fun setDoneButtonDrawable(icon: Drawable?): ImagePickerCreator = this.apply {
        config.drawableDoneButton = icon
    }

    override fun setAllDoneButtonDrawable(icon: Drawable?): ImagePickerCreator = this.apply {
        config.drawableAllDoneButton = icon
    }

    override fun setIsUseAllDoneButton(isUse: Boolean): ImagePickerCreator = this.apply {
        config.isUseAllDoneButton = isUse
    }

    @Deprecated("instead setMaxCount(count)", ReplaceWith("exceptMimeType(mimeType)"))
    override fun exceptGif(isExcept: Boolean): ImagePickerCreator = this.apply {
        config.exceptMimeTypeList = arrayListOf(MimeType.GIF)
    }

    override fun exceptMimeType(exceptMimeTypeList: List<MimeType>) = this.apply {
        config.exceptMimeTypeList = exceptMimeTypeList
    }

    override fun setMenuDoneText(text: String?): ImagePickerCreator = this.apply {
        config.strDoneMenu = text
    }

    override fun setMenuAllDoneText(text: String?): ImagePickerCreator = this.apply {
        config.strAllDoneMenu = text
    }

    override fun setMenuTextColor(color: Int): ImagePickerCreator = this.apply {
        config.colorTextMenu = color
    }

    override fun setIsUseDetailView(isUse: Boolean): ImagePickerCreator = this.apply {
        config.isUseDetailView = isUse
    }

    override fun setIsShowCount(isShow: Boolean): ImagePickerCreator = this.apply {
        config.isShowCount = isShow
    }

    override fun setSelectCircleStrokeColor(strokeColor: Int): ImagePickerCreator = this.apply {
        config.colorSelectCircleStroke = strokeColor
    }

    override fun isStartInAllView(isStartInAllView: Boolean): ImagePickerCreator = this.apply {
        config.isStartInAllView = isStartInAllView
    }

    override fun pickCameraOnly(isAutomaticRunningCamera: Boolean): ImagePickerCreator = this.apply {
        config.isAutomaticRunningCamera = isAutomaticRunningCamera
    }

    override fun setSpecifyFolderList(specifyFolderList: List<String>) = this.apply {
        config.specifyFolderList = specifyFolderList
    }

    private fun prepareStartAlbum(context: Context) {
        checkNotNull(config.imageAdapter)
        exceptionHandling()
        setDefaultValue(context)
    }

    @Deprecated(
        "instead startAlbumWithOnActivityResult(requestCode)",
        ReplaceWith("startAlbumWithOnActivityResult(requestCode)")
    )
    override fun startAlbum() {
        val imagePickerContext = imagePicker.ipContext
        val context = imagePickerContext.getContext()

        prepareStartAlbum(context)

        imagePickerContext.startActivityForResult(getIntent(context), requestCode)
    }

    override fun startAlbumWithOnActivityResult(requestCode: Int) {
        val imagePickerContext = imagePicker.ipContext
        val context = imagePickerContext.getContext()

        prepareStartAlbum(context)

        imagePickerContext.startActivityForResult(getIntent(context), requestCode)
    }

    override fun startAlbumWithActivityResultCallback(activityResultLauncher: ActivityResultLauncher<Intent>) {
        val imagePickerContext = imagePicker.ipContext
        val context = imagePickerContext.getContext()

        prepareStartAlbum(context)

        imagePickerContext.startWithRegisterForActivityResult(
            activityResultLauncher,
            getIntent(context)
        )
    }

    private fun getIntent(context: Context): Intent {
        return if (config.isAutomaticRunningCamera) {
            println("isAutomaticRunningCamera true")
            PickerActivity.getPickerActivityIntent(context, 0L, config.titleAlbumAllView, 0)
        }  else {
            println("isAutomaticRunningCamera false AlbumActivity")
            Intent(context, AlbumActivity::class.java)
        }
    }

    private fun setDefaultValue(context: Context) {
        with(config) {
            setDefaultMessage(context)
            setMenuTextColor()
            setDefaultDimen(context)
        }
    }

    private fun exceptionHandling() {
        if (config.hasCameraInPickerPage) {
            config.hasCameraInPickerPage = config.specifyFolderList.isEmpty()
        }
    }
}

