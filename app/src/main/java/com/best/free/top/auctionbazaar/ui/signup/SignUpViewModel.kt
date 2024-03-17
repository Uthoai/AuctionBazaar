package com.best.free.top.auctionbazaar.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.best.free.top.auctionbazaar.DataState
import com.best.free.top.auctionbazaar.source_repo.AuthRepository

class SignUpViewModel: ViewModel() {
    private val userSignUpResponse = MutableLiveData<DataState<UserSignUp>>()
    val userSignUpResponse_ : LiveData<DataState<UserSignUp>> = userSignUpResponse
    fun userSignUp(userSignUp: UserSignUp){
        userSignUpResponse.postValue(DataState.Loading())

        val authRepository = AuthRepository()
        authRepository.userSignUp(userSignUp).addOnSuccessListener {
            userSignUpResponse.postValue(DataState.Success(userSignUp))
        }.addOnFailureListener {
            userSignUpResponse.postValue(DataState.Error(it.message))
        }
    }
}
