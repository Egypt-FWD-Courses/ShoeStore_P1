package com.example.shoestore_p1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.shoestore_p1.databinding.FragmentUserBinding



class User : Fragment() {

    private lateinit var binding: FragmentUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Shoes outlet (Login)"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false)
        binding.createButton.setOnClickListener { view: View ->
            welcomeCheck(view)
        }
        binding.loginButton.setOnClickListener{ view: View ->
            welcomeCheck(view)
        }
        binding.userPassword.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus){
                val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.userPassword.windowToken, 0)
            }
        }
        return binding.root
    }

    private fun welcomeCheck(view: View){
        if (binding.userEmail.text.isEmpty() || binding.userPassword.text.isEmpty()) {
            binding.alertLabel.visibility = View.VISIBLE
        }
        else {
            binding.alertLabel.visibility = View.INVISIBLE
            view.findNavController().navigate(UserDirections.actionUserToWelcome(binding.userEmail.text.toString()))
        }
    }


}

