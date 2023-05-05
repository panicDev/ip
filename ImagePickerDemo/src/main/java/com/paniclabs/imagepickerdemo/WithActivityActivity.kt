package com.paniclabs.imagepickerdemo

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.paniclabs.imagepicker.ImagePicker
import com.paniclabs.imagepicker.MimeType
import com.paniclabs.imagepicker.adapter.image.impl.GlideAdapter
import com.paniclabs.imagepickerdemo.databinding.ActivityWithactivityBinding

class WithActivityActivity : AppCompatActivity() {

    var path = ArrayList<Uri>()
    private lateinit var imageAdapter: ImageAdapter
    private var mode: Int = 0
    private lateinit var binding: ActivityWithactivityBinding
    private val startForResultCallback =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                path =
                    it.data?.getParcelableArrayListExtra(ImagePicker.INTENT_PATH) ?: arrayListOf()
                Log.i("PathLog", path.joinToString())
                imageAdapter.changePath(path)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWithactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mode = intent.getIntExtra("mode", -1)

        with(binding.recyclerview) {
            layoutManager = LinearLayoutManager(
                this@WithActivityActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )

            imageAdapter = ImageAdapter(context, ImageController(binding.imgMain), path)
            adapter = imageAdapter
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(
        requestCode: Int, resultCode: Int,
        imageData: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, imageData)

        if (requestCode == ImagePicker.IMAGE_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {
            path = imageData?.getParcelableArrayListExtra(ImagePicker.INTENT_PATH) ?: arrayListOf()
            imageAdapter.changePath(path)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_plus) {
            when (mode) {
                //basic
                0 -> {
                    ImagePicker.with(this@WithActivityActivity)
                        .setImageAdapter(GlideAdapter())
                        .setSelectedImages(path)
                        .pickCameraOnly(true)
                        .startAlbumWithActivityResultCallback(startForResultCallback)
                }
                //dark
                1 -> {
                    ImagePicker.with(this@WithActivityActivity)
                        .setImageAdapter(GlideAdapter())
                        .setMaxCount(5)
                        .setMinCount(3)
                        .setPickerSpanCount(3)
                        .setActionBarColor(
                            Color.parseColor("#E85350"),
                            Color.parseColor("#E85350"),
                            false
                        )
                        .setActionBarTitleColor(Color.parseColor("#ffffff"))
                        .setSelectedImages(path)
                        .setIsUseDetailView(false)
                        .setAlbumSpanCount(2, 3)
                        .setButtonInAlbumActivity(false)
                        .hasCameraInPickerPage(true)
                        .exceptMimeType(arrayListOf(MimeType.GIF))
                        .setReachLimitAutomaticClose(true)
                        .setHomeAsUpIndicatorDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.ic_custom_back_white
                            )
                        )
                        .setDoneButtonDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.ic_custom_ok
                            )
                        )
                        .setAllViewTitle("All")
                        .setActionBarTitle("FishBun Dark")
                        .textOnNothingSelected("Please select three or more!")
                        .startAlbumWithActivityResultCallback(startForResultCallback)
                }
                //Light
                2 -> {
                    ImagePicker.with(this@WithActivityActivity)
                        .setImageAdapter(GlideAdapter())
                        .setMaxCount(50)
                        .setPickerSpanCount(4)
                        .setActionBarTitleColor(Color.parseColor("#000000"))
                        .setSelectedImages(path)
                        .setAlbumSpanCount(1, 2)
                        .setButtonInAlbumActivity(true)
                        .hasCameraInPickerPage(false)
                        .exceptMimeType(arrayListOf(MimeType.GIF))
                        .setReachLimitAutomaticClose(false)
                        .setHomeAsUpIndicatorDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.ic_arrow_back_black_24dp
                            )
                        )

                        .setIsUseAllDoneButton(true)
                        .setMenuDoneText("Choose")
                        .setMenuAllDoneText("Choose All")
                        .setIsUseAllDoneButton(true)
                        .setAllViewTitle("All of your photos")
                        .setActionBarTitle("FishBun Light")
                        .textOnImagesSelectionLimitReached("You can't select any more.")
                        .textOnNothingSelected("I need a photo!")
                        .startAlbumWithActivityResultCallback(startForResultCallback)
                }
                else -> {
                    finish()
                }
            }

            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
