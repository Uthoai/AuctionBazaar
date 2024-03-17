package com.best.free.top.auctionbazaar.ui.signup

import android.content.Intent
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.best.free.top.auctionbazaar.R
import com.best.free.top.auctionbazaar.base.BaseFragment
import com.best.free.top.auctionbazaar.databinding.FragmentSignUpBinding
import com.best.free.top.auctionbazaar.isEmpty
import com.best.free.top.auctionbazaar.ui.dashboard.DashboardActivity

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {
    override fun allObserver() {
    }

    override fun setListener() {
        with(binding){
            btnSignup.setOnClickListener {
                etEmail.isEmpty()
                etName.isEmpty()
                etPassword.isEmpty()
                if (!etEmail.isEmpty() && !etName.isEmpty() && !etPassword.isEmpty()){
                    if (etName.text.toString().length >= 3){
                        checkEmailPasswordValidity()
                    }
                }
            }
            btnLogin.setOnClickListener {
                findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
            }
        }
    }

    private fun checkEmailPasswordValidity() {
        val emailPattern = Regex("^[a-z0-9]+@[a-z]+\\.[a-z]{2,4}$")
        val name = binding.etName.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        if (emailPattern.matches(email)){
            if (password.length>=8){
                /*val user = UserSignUp(
                    name,
                    email,
                    password,
                    "Seller",
                    ""
                )
                viewModel.userSignup(user)*/
                startActivity(Intent(requireContext(), DashboardActivity::class.java))
                requireActivity().finish()
            }
            else{
                Toast.makeText(context, "enter correct password", Toast.LENGTH_SHORT).show()
            }
        }
        else{
            Toast.makeText(context, "enter correct email/password", Toast.LENGTH_SHORT).show()
        }
    }
}
