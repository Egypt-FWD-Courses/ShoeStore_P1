package com.example.shoestore_p1.outlet

import androidx.lifecycle.ViewModel
import com.example.shoestore_p1.Shoes

class OutletViewModel: ViewModel() {

    private var shoesList: MutableList<Shoes> = mutableListOf()

    init {
        insertInitialData()
    }

    private fun insertInitialData () {
        val shoesName = mutableListOf(
            "dummy1", "dummy2", "dummy3", "dummy4"
        )
        val shoesCompany = mutableListOf(
            "Dummy1", "Dummy2", "Dummy3", "Dummy4"
        )
        val shoesSize = mutableListOf(
            "DuMmy1", "DuMmy2", "DuMmy3", "DuMmy4"
        )
        val shoesDescription = mutableListOf(
            "DuMmy1", "DuMmy2", "DuMmy3", "DuMmy4"
        )

        for (i in 0..3){
            val shoe = Shoes(shoesName[i],shoesCompany[i], shoesSize[i], shoesDescription[i])
            shoesList += shoe
        }
    }
}