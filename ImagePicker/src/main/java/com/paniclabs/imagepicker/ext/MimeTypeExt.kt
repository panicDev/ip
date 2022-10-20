@file:JvmName("MimeTypeExt")

package com.paniclabs.imagepicker.ext

import com.paniclabs.imagepicker.MimeType


fun MimeType.equalsMimeType(mimeType: String) = this.type == mimeType
