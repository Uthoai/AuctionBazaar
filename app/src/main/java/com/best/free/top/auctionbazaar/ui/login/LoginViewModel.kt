package com.best.free.top.auctionbazaar.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.best.free.top.auctionbazaar.DataState
import com.best.free.top.auctionbazaar.source_repo.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authRepository: AuthRepository): ViewModel() {
    private val userLoginResponse = MutableLiveData<DataState<UserLogin>>()
    val userLoginResponse_ : LiveData<DataState<UserLogin>> = userLoginResponse
    fun userLogin(userLogin: UserLogin){
        userLoginResponse.postValue(DataState.Loading())

        authRepository.userLogin(userLogin).addOnSuccessListener {
            userLoginResponse.postValue(DataState.Success(userLogin))
        }.addOnFailureListener {
            userLoginResponse.postValue(DataState.Error(it.message))
        }
    }
}