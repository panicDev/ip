package com.paniclabs.imagepicker.ui.album.listener

import com.paniclabs.imagepicker.ui.album.model.Album

interface AlbumClickListener {
    fun onAlbumClick(position: Int, album: Album)
}
