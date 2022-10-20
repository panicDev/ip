package com.paniclabs.imagepicker.datasource

interface CameraDataSource {
    fun getCameraPath(): String
    fun getPicturePath(): String?
}
