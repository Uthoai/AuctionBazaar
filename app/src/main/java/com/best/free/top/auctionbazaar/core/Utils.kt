package com.best.free.top.auctionbazaar.core

import android.widget.EditText
fun EditText.isEmpty(): Boolean{
    return if (this.text.toString().isEmpty()){
        this.error = "fill up please"
        true
    }
    else{
        false
    }
}