package com.best.free.top.auctionbazaar.source_repo

import com.best.free.top.auctionbazaar.ui.login.UserLogin
import com.best.free.top.auctionbazaar.ui.signup.UserSignUp
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class AuthRepository: AuthSource {
    private val mAuth = FirebaseAuth.getInstance()
    override fun userSignUp(userSignUp: UserSignUp): Task<AuthResult> {
        return mAuth.createUserWithEmailAndPassword(userSignUp.email,userSignUp.password)
    }
    override fun userLogin(userLogin: UserLogin): Task<AuthResult> {
        return mAuth.signInWithEmailAndPassword(userLogin.email,userLogin.password)
    }
}
