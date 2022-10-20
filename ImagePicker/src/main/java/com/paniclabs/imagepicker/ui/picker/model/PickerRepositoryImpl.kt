package com.paniclabs.imagepicker.ui.picker.model

import android.net.Uri
import android.os.Build
import com.paniclabs.imagepicker.adapter.image.ImageAdapter
import com.paniclabs.imagepicker.datasource.CameraDataSource
import com.paniclabs.imagepicker.datasource.ImagePickerDataSource
import com.paniclabs.imagepicker.datasource.ImageDataSource
import com.paniclabs.imagepicker.datasource.PickerIntentDataSource
import com.paniclabs.imagepicker.ui.picker.model.AlbumData
import com.paniclabs.imagepicker.util.future.CallableFutureTask

class PickerRepositoryImpl(
    private val imageDataSource: ImageDataSource,
    private val imagePickerDataSource: ImagePickerDataSource,
    private val pickerIntentDataSource: PickerIntentDataSource,
    private val cameraDataSource: CameraDataSource
) : PickerRepository {

    private var cachedAllMediaThumbNailPath: CallableFutureTask<List<Uri>>? = null

    override fun getAllBucketImageUri(
        bucketId: Long,
        clearCache: Boolean
    ): CallableFutureTask<List<Uri>> {
        if (clearCache) cachedAllMediaThumbNailPath = null

        return cachedAllMediaThumbNailPath
            ?: imageDataSource.getAllBucketImageUri(
                bucketId,
                imagePickerDataSource.getExceptMimeTypeList(),
                imagePickerDataSource.getSpecifyFolderList()
            ).also { cachedAllMediaThumbNailPath = it }
    }

    override fun getDirectoryPath(bucketId: Long): CallableFutureTask<String> {
        return imageDataSource.getDirectoryPath(bucketId)
    }

    override fun addAddedPath(addedImage: Uri) {
        imageDataSource.addAddedPath(addedImage)
    }

    override fun getAddedPathList() = imageDataSource.getAddedPathList()

    override fun addAllAddedPath(addedImagePathList: List<Uri>) {
        imageDataSource.addAllAddedPath(addedImagePathList)
    }

    override fun getPickerAlbumData(): AlbumData? {
        return pickerIntentDataSource.getAlbumData()
    }

    override fun getPickerViewData(): PickerViewData = imagePickerDataSource.getPickerViewData()

    override fun setCurrentPickerImageList(pickerImageList: List<Uri>) {
        imagePickerDataSource.setCurrentPickerImageList(pickerImageList)
    }

    override fun getSelectedImageList() = imagePickerDataSource.getSelectedImageList()

    override fun getImageAdapter(): ImageAdapter = imagePickerDataSource.getImageAdapter()

    override fun hasCameraInPickerPage(): Boolean {
        return when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q -> {
                imagePickerDataSource.hasCameraInPickerPage()
                        && pickerIntentDataSource.getAlbumData()?.albumId == 0L
            }
            else -> {
                imagePickerDataSource.hasCameraInPickerPage()
            }
        }
    }

    override fun useDetailView() = imagePickerDataSource.useDetailView()

    override fun isLimitReached() =
        imagePickerDataSource.getMaxCount() == imagePickerDataSource.getSelectedImageList().size

    override fun selectImage(imageUri: Uri) = imagePickerDataSource.selectImage(imageUri)

    override fun unselectImage(imageUri: Uri) = imagePickerDataSource.unselectImage(imageUri)

    override fun isNotSelectedImage(imageUri: Uri) =
        !imagePickerDataSource.getSelectedImageList().contains(imageUri)

    override fun getSelectedImage(position: Int): Uri =
        imagePickerDataSource.getSelectedImageList()[position]

    override fun getSelectedIndex(imageUri: Uri) = getSelectedImageList().indexOf(imageUri)

    override fun getPickerImage(imagePosition: Int) =
        imagePickerDataSource.getPickerImages()[imagePosition]

    override fun getMessageLimitReached() = imagePickerDataSource.getMessageLimitReached()

    override fun getPickerMenuViewData(): PickerMenuViewData =
        imagePickerDataSource.getPickerMenuViewData()

    override fun getMinCount() = imagePickerDataSource.getMinCount()

    override fun getMaxCount() = imagePickerDataSource.getMinCount()

    override fun getPickerImages() = imagePickerDataSource.getPickerImages()

    override fun getMessageNotingSelected() = imagePickerDataSource.getMessageNothingSelected()

    override fun checkForFinish(): Boolean =
        imagePickerDataSource.getIsAutomaticClose()
                && imagePickerDataSource.getSelectedImageList().size == imagePickerDataSource.getMaxCount()

    override fun isStartInAllView() = imagePickerDataSource.isStartInAllView()

    override fun getDefaultSavePath(): String? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            cameraDataSource.getPicturePath()
        } else {
            cameraDataSource.getCameraPath()
        }
    }

    override fun isUseOnlyCamera(): Boolean = imagePickerDataSource.getIsAutomaticRunCamera()
}
