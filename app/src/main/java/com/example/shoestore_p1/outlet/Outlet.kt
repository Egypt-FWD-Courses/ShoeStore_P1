package com.example.shoestore_p1.outlet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.shoestore_p1.R
import com.example.shoestore_p1.databinding.FragmentOutletBinding


class Outlet : Fragment() {

    private lateinit var binding: FragmentOutletBinding
    private lateinit var viewModel: OutletViewModel

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.title = "Shoes outlet"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_outlet, container, false)
        viewModel = ViewModelProvider(this).get(OutletViewModel::class.java)

        return binding.root
    }

}