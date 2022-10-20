package com.paniclabs.imagepicker.datasource

import com.paniclabs.imagepicker.ui.picker.model.AlbumData

interface PickerIntentDataSource {
    fun getAlbumData(): AlbumData?
}
