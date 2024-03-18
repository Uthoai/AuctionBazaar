package com.best.free.top.auctionbazaar.source_repo

import com.best.free.top.auctionbazaar.core.Nodes
import com.best.free.top.auctionbazaar.ui.login.UserLogin
import com.best.free.top.auctionbazaar.ui.signup.UserSignUp
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val mAuth: FirebaseAuth, private val db: FirebaseFirestore): AuthSource {
    override fun userSignUp(userSignUp: UserSignUp): Task<AuthResult> {
        return mAuth.createUserWithEmailAndPassword(userSignUp.email,userSignUp.password)
    }
    override fun userLogin(userLogin: UserLogin): Task<AuthResult> {
        return mAuth.signInWithEmailAndPassword(userLogin.email,userLogin.password)
    }

    override fun createUser(userSignUp: UserSignUp): Task<Void> {
        return db.collection(Nodes.USER).document(userSignUp.userID).set(userSignUp)
    }
}
