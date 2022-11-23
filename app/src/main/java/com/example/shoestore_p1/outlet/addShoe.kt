package com.example.shoestore_p1.outlet

import android.content.Context
import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.shoestore_p1.R
import com.example.shoestore_p1.UserDirections
import com.example.shoestore_p1.databinding.FragmentAddShoeBinding

class addShoe : Fragment() {

    private lateinit var binding: FragmentAddShoeBinding
    private lateinit var viewModel: OutletViewModel
    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.title = "Add shoes"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(requireActivity())[OutletViewModel::class.java]
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_shoe, container, false)

        binding.cancel.setOnClickListener { view:View ->
            view.findNavController().navigate(addShoeDirections.actionAddShoeToOutlet())
        }
        binding.viewModel = viewModel
        binding.save.setOnClickListener { view:View ->
            addShoes(view)
        }
        binding.descriptionValue.setOnFocusChangeListener{ v, hasFocus ->
            if (!hasFocus){
                val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.descriptionValue.windowToken, 0)
            }
        }
        return binding.root
    }
    private fun addShoes(view: View){
        if (binding.nameValue.text.isEmpty() || binding.sizeValue.text.isEmpty() ||
            binding.brandValue.text.isEmpty() || binding.descriptionValue.text.isEmpty()) {
            binding.alertLabel2.visibility = View.VISIBLE
        }
        else {
            binding.alertLabel2.visibility = View.INVISIBLE
            val shoeDetails = arrayOf(binding.nameValue.text.toString(), binding.sizeValue.text.toString(),
            binding.brandValue.text.toString(), binding.descriptionValue.text.toString())
            binding.viewModel!!.insert()
            view.findNavController().navigate(addShoeDirections.actionAddShoeToOutlet())
        }
    }
}