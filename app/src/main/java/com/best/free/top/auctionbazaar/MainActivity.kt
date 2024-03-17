package com.best.free.top.auctionbazaar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.best.free.top.auctionbazaar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}