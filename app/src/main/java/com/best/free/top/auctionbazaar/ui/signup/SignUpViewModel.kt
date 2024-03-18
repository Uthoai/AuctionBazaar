package com.best.free.top.auctionbazaar.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.best.free.top.auctionbazaar.core.DataState
import com.best.free.top.auctionbazaar.source_repo.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val authRepository: AuthRepository): ViewModel() {
    private val userSignUpResponse = MutableLiveData<DataState<UserSignUp>>()
    val userSignUpResponse_ : LiveData<DataState<UserSignUp>> = userSignUpResponse
    fun userSignUp(userSignUp: UserSignUp){
        userSignUpResponse.postValue(DataState.Loading())

        authRepository.userSignUp(userSignUp).addOnSuccessListener {    //success for auth
            it.user?.let { createUser->
                userSignUp.userID = createUser.uid
                authRepository.createUser(userSignUp).addOnSuccessListener {    //success for create & store to database
                    userSignUpResponse.postValue(DataState.Success(userSignUp))
                }.addOnFailureListener {
                    userSignUpResponse.postValue(DataState.Error(it.message))
                }
            }

        }.addOnFailureListener {
            userSignUpResponse.postValue(DataState.Error(it.message))
        }
    }
}
