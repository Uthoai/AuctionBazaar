package com.best.free.top.auctionbazaar.ui.login

import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.best.free.top.auctionbazaar.DataState
import com.best.free.top.auctionbazaar.R
import com.best.free.top.auctionbazaar.base.BaseFragment
import com.best.free.top.auctionbazaar.databinding.FragmentLoginBinding
import com.best.free.top.auctionbazaar.isEmpty
import com.best.free.top.auctionbazaar.ui.dashboard.DashboardActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private val viewModel : LoginViewModel by viewModels()
    override fun allObserver() {
        loginObserver()
    }
    override fun setListener() {
        with(binding){
            btnLogin.setOnClickListener {
                etEmail.isEmpty()
                etPassword.isEmpty()
                if (!etEmail.isEmpty() && !etPassword.isEmpty()){
                    checkEmailPasswordValidity()
                }
            }
            txtBtnSignup.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
            }
        }
    }
    private fun checkEmailPasswordValidity() {
        val emailPattern = Regex("^[a-z0-9]+@[a-z]+\\.[a-z]{2,4}$")
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        if (emailPattern.matches(email)){
            if (password.length>=8){
                val user = UserLogin(
                    email,
                    password
                )
                viewModel.userLogin(user)
            }
            else{
                Toast.makeText(context, "enter correct password", Toast.LENGTH_SHORT).show()
            }
        }
        else{
            Toast.makeText(context, "enter correct email/password", Toast.LENGTH_SHORT).show()
        }
    }
    private fun loginObserver() {
        viewModel.userLoginResponse_.observe(viewLifecycleOwner){
            when(it){
                is DataState.Error -> {
                    loading.dismiss()
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading -> {
                    loading.show()
                }
                is DataState.Success -> {
                    loading.dismiss()
                    startActivity(Intent(requireContext(),DashboardActivity::class.java))
                    requireActivity().finish()
                }
            }
        }
    }
}
