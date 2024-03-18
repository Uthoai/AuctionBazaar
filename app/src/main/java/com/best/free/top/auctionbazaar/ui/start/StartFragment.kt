package com.best.free.top.auctionbazaar.ui.start

import androidx.navigation.fragment.findNavController
import com.best.free.top.auctionbazaar.R
import com.best.free.top.auctionbazaar.base.BaseFragment
import com.best.free.top.auctionbazaar.databinding.FragmentStartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment : BaseFragment<FragmentStartBinding>(FragmentStartBinding::inflate){
    override fun allObserver() {
    }

    override fun setListener() {
        with(binding){
            btnLogin.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_loginFragment)
            }
            btnSignup.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_signUpFragment)
            }
        }
    }

}
