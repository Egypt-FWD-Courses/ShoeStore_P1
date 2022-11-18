package com.example.shoestore_p1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
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
        binding.createButton.setOnClickListener {
            welcomeCheck()
        }
        return binding.root
    }

    private fun welcomeCheck(){
        if (binding.userEmail.text.isEmpty() || binding.userPassword.text.isEmpty()){
            binding.alertLabel.visibility = View.VISIBLE
        }
        else {
            binding.alertLabel.visibility = View.INVISIBLE
        }
    }
}

