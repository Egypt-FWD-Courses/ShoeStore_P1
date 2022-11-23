package com.example.shoestore_p1.outlet


import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.shoestore_p1.R
import com.example.shoestore_p1.databinding.FragmentOutletBinding


class Outlet : Fragment() {

    private lateinit var binding: FragmentOutletBinding
    private lateinit var viewModel: OutletViewModel
    private lateinit var outletView: LinearLayout
    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.title = "Shoes outlet"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_outlet, container, false)

        val controller = findNavController()
        controller.clearBackStack(R.id.login)

        viewModel = ViewModelProvider(requireActivity())[OutletViewModel::class.java]
        outletView = binding.shoesData
        binding.lifecycleOwner = viewLifecycleOwner

        val args = OutletArgs.fromBundle(requireArguments())
        if (args.shoeName != null){
            viewModel.insertShoe(args.shoeName!!, args.shoeSize!!, args.shoeBrand!!, args.shoeDescription!!)
        }

        viewModel.shoesList.observe(viewLifecycleOwner) { shoes ->
            for (i in 0 until shoes.size) {
                val shoe = shoes[i]
                if (i % 2 == 0) {
                    addLayout(shoe.name, shoe.size, shoe.company, shoe.description, true)
                } else {
                    addLayout(shoe.name, shoe.size, shoe.company, shoe.description)
                }
            }
        }
        binding.addButton.setOnClickListener{view:View ->
            view.findNavController().navigate(OutletDirections.actionOutletToAddShoe())
        }

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.logout, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.login -> {
                        val controller = Navigation.findNavController(requireActivity(), R.id.myNavHostFragment)
                        controller.navigate(R.id.login)
                        return true
                    }
                }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
        return binding.root
    }



    @RequiresApi(Build.VERSION_CODES.M)
    private fun addLayout(productName: String, productSize: String, productBrand: String, productDescription: String, colored: Boolean = false){
        // Add the name label
        val nameLabel = TextView(context)
        nameLabel.text = "Name:"
        nameLabel.setTextAppearance(R.style.shoesTitles)

        // Add the name value
        val nameValue = TextView(context)
        nameValue.text = productName
        nameValue.setTextAppearance(R.style.shoeDetails)
        val nameParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        nameParams.setMargins(25, 0, 0, 0)
        nameValue.layoutParams = nameParams

        // Add the size label
        val sizeLabel = TextView(context)
        sizeLabel.text = "Size:"
        sizeLabel.setTextAppearance(R.style.shoesTitles)
        val sizeLabelParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        sizeLabelParams.setMargins(235, 0, 0, 0)
        sizeLabel.layoutParams = sizeLabelParams

        // Add the size value
        val sizeValue = TextView(context)
        sizeValue.text = productSize
        sizeValue.setTextAppearance(R.style.shoeDetails)
        val sizeValueParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        sizeValueParams.setMargins(35, 0, 0, 0)
        sizeValue.layoutParams = sizeValueParams

        // Add all values in the name&size layout
        val name_size_layout = LinearLayout(context)
        val nameLayoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        nameLayoutParams.setMargins(0, 0, 0, 30)
        name_size_layout.layoutParams = nameLayoutParams
        name_size_layout.addView(nameLabel)
        name_size_layout.addView(nameValue)
        name_size_layout.addView(sizeLabel)
        name_size_layout.addView(sizeValue)

        // Add the brand label
        val brandLabel = TextView(context)
        brandLabel.text = "Brand:"
        brandLabel.setTextAppearance(R.style.shoesTitles)

        // Add the brand value
        val brandValue = TextView(context)
        brandValue.text = productBrand
        brandValue.setTextAppearance(R.style.shoeDetails)
        val brandValueParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        brandValueParams.setMargins(25, 0, 0, 0)
        brandValue.layoutParams = brandValueParams

        // Add all values in the brand layout
        val brand_layout = LinearLayout(context)
        brand_layout.layoutParams = nameLayoutParams
        brand_layout.addView(brandLabel)
        brand_layout.addView(brandValue)

        // Add the description label
        val descriptionLabel = TextView(context)
        descriptionLabel.text = "Description:"
        descriptionLabel.setTextAppearance(R.style.shoesTitles)

        // Add the description value
        val descriptionValue = TextView(context)
        descriptionValue.text = productDescription
        descriptionValue.setTextAppearance(R.style.shoeDetails)
        val descriptionValueParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        descriptionValueParams.setMargins(25, 0, 0, 20)
        descriptionValue.layoutParams = descriptionValueParams

        // Add all values in the brand layout
        val description_layout = LinearLayout(context)
        val descriptionLayoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )

        description_layout.layoutParams = descriptionLayoutParams
        description_layout.addView(descriptionLabel)
        description_layout.addView(descriptionValue)


        val whole_layout = LinearLayout(context)
        whole_layout.orientation = LinearLayout.VERTICAL
        whole_layout.addView(name_size_layout)
        whole_layout.addView(brand_layout)
        whole_layout.addView(description_layout)
        val wholeParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        wholeParams.setMargins(0, 30, 0, 80)
        whole_layout.layoutParams = wholeParams
        if(colored){
            whole_layout.setBackgroundColor((Color.parseColor("#C5C5C5")))
        }

        outletView.addView(whole_layout)

    }

}