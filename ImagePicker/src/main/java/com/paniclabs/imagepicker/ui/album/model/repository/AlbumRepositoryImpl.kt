package com.paniclabs.imagepicker.ui.album.model.repository

import android.os.Build
import com.paniclabs.imagepicker.datasource.CameraDataSource
import com.paniclabs.imagepicker.datasource.ImagePickerDataSource
import com.paniclabs.imagepicker.datasource.ImageDataSource
import com.paniclabs.imagepicker.ui.album.model.Album
import com.paniclabs.imagepicker.ui.album.model.AlbumMetaData
import com.paniclabs.imagepicker.ui.album.model.AlbumViewData
import com.paniclabs.imagepicker.util.future.CallableFutureTask

class AlbumRepositoryImpl(
    private val imageDataSource: ImageDataSource,
    private val imagePickerDataSource: ImagePickerDataSource,
    private val cameraDataSource: CameraDataSource
) : AlbumRepository {

    private var viewData: AlbumViewData? = null

    override fun getAlbumList(): CallableFutureTask<List<Album>> {
        return imageDataSource.getAlbumList(
            imagePickerDataSource.getAllViewTitle(),
            imagePickerDataSource.getExceptMimeTypeList(),
            imagePickerDataSource.getSpecifyFolderList()
        )
    }

    override fun getAlbumMetaData(albumId: Long): CallableFutureTask<AlbumMetaData> {
        return imageDataSource.getAlbumMetaData(
            albumId,
            imagePickerDataSource.getExceptMimeTypeList(),
            imagePickerDataSource.getSpecifyFolderList()
        )
    }

    override fun getAlbumViewData(): AlbumViewData {
        return viewData ?: imagePickerDataSource.getAlbumViewData().also { viewData = it }
    }

    override fun getImageAdapter() = imagePickerDataSource.getImageAdapter()

    override fun getSelectedImageList() = imagePickerDataSource.getSelectedImageList()

    override fun getAlbumMenuViewData() = imagePickerDataSource.gatAlbumMenuViewData()

    override fun getMessageNotingSelected() = imagePickerDataSource.getMessageNothingSelected()

    override fun getMinCount() = imagePickerDataSource.getMinCount()

    override fun getDefaultSavePath(): String? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            cameraDataSource.getPicturePath()
        } else {
            cameraDataSource.getCameraPath()
        }
    }
}
