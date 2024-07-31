package com.example.demofragmentinandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.demofragmentinandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            // style java
//            supportFragmentManager.beginTransaction()
//                .add(binding.fragmentContainerView.id, FirstFragment().apply {
//                    arguments = bundleOf("name" to "Minh Khang", "age" to "20")
//                })
//                .commit()

            // style kotlin
            supportFragmentManager.commit {
//                add(binding.fragmentContainerView.id, FirstFragment().apply {
//                    arguments = bundleOf("name" to "Minh Khang", "age" to "20")
//                })

                add<FirstFragment>(
                    containerViewId = binding.fragmentContainerView.id,
                    args = bundleOf("name" to "Minh Khang", "age" to "20")
                )
            }
        }
    }
}