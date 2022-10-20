package com.paniclabs.imagepicker.util

import android.os.Handler
import android.os.Looper


class MainUiHandler : UiHandler {
    private val handler: Handler = Handler(Looper.getMainLooper())
    override fun run(block: () -> Unit) {
        handler.post {
            block.invoke()
        }
    }
}
