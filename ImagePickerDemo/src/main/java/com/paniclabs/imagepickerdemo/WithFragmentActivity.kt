package com.paniclabs.imagepickerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.paniclabs.imagepickerdemo.databinding.ActivityWithfragmentBinding

class WithFragmentActivity : AppCompatActivity() {

    private lateinit var subFragment: SubFragment
    private lateinit var binding: ActivityWithfragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWithfragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        subFragment = SubFragment.newInstance()
        supportFragmentManager.beginTransaction().add(binding.areaContainer.id, subFragment)
            .commit()
    }
}
