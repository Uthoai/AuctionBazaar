package com.best.free.top.auctionbazaar.source_repo

import com.best.free.top.auctionbazaar.ui.login.UserLogin
import com.best.free.top.auctionbazaar.ui.signup.UserSignUp
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthSource {
    fun userSignUp(userSignUp: UserSignUp): Task<AuthResult>
    fun userLogin(userLogin: UserLogin): Task<AuthResult>
    fun createUser(userSignUp: UserSignUp): Task<Void>

}