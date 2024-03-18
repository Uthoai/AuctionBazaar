package com.best.free.top.auctionbazaar.ui.start

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.best.free.top.auctionbazaar.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}