package com.example.demofragmentinandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demofragmentinandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(binding.fragmentContainerView.id, FirstFragment())
        fragmentTransaction.commit()
    }
}