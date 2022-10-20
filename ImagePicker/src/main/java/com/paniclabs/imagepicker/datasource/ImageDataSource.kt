package com.paniclabs.imagepicker.datasource

import android.net.Uri
import com.paniclabs.imagepicker.MimeType
import com.paniclabs.imagepicker.ui.album.model.Album
import com.paniclabs.imagepicker.ui.album.model.AlbumMetaData
import com.paniclabs.imagepicker.util.future.CallableFutureTask

interface ImageDataSource {
    fun getAlbumList(
        allViewTitle: String,
        exceptMimeTypeList: List<MimeType>,
        specifyFolderList: List<String>
    ): CallableFutureTask<List<Album>>

    fun getAllBucketImageUri(
        bucketId: Long,
        exceptMimeTypeList: List<MimeType>,
        specifyFolderList: List<String>
    ): CallableFutureTask<List<Uri>>

    fun getAlbumMetaData(
        bucketId: Long,
        exceptMimeTypeList: List<MimeType>,
        specifyFolderList: List<String>
    ): CallableFutureTask<AlbumMetaData>

    fun getDirectoryPath(bucketId: Long): CallableFutureTask<String>

    fun addAddedPath(addedImage: Uri)

    fun addAllAddedPath(addedImageList: List<Uri>)

    fun getAddedPathList(): List<Uri>
}
