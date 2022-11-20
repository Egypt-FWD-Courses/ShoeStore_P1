package com.example.shoestore_p1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore_p1.databinding.FragmentInstructionsBinding

class instructions : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding
    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.title = "Shoes outlet (Instructions)"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
        binding.insturctionButton.setOnClickListener{ view: View ->
            view.findNavController().navigate(instructionsDirections.actionInstructionsToOutlet(null,null,null,null))
        }
        return binding.root
    }

}