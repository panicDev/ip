package com.paniclabs.imagepicker.ui.album.model.repository

import android.net.Uri
import com.paniclabs.imagepicker.adapter.image.ImageAdapter
import com.paniclabs.imagepicker.ui.album.model.Album
import com.paniclabs.imagepicker.ui.album.model.AlbumMenuViewData
import com.paniclabs.imagepicker.ui.album.model.AlbumMetaData
import com.paniclabs.imagepicker.ui.album.model.AlbumViewData
import com.paniclabs.imagepicker.util.future.CallableFutureTask

interface AlbumRepository {
    fun getAlbumList(): CallableFutureTask<List<Album>>

    fun getAlbumMetaData(albumId: Long): CallableFutureTask<AlbumMetaData>

    fun getAlbumViewData(): AlbumViewData

    fun getImageAdapter(): ImageAdapter

    fun getSelectedImageList(): List<Uri>

    fun getAlbumMenuViewData(): AlbumMenuViewData

    fun getMessageNotingSelected(): String

    fun getMinCount(): Int

    fun getDefaultSavePath(): String?
}
