package com.example.shoestore_p1.outlet

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore_p1.Shoes
import kotlin.math.log

class OutletViewModel: ViewModel() {

    private var _shoesList = MutableLiveData<MutableList<Shoes>>()
    val newShoe = Shoes()
    val shoesList: LiveData<MutableList<Shoes>>
        get() = _shoesList

    init {
        insertInitialData()
    }

    private fun insertInitialData () {
        _shoesList.value = mutableListOf()
        val shoesName = mutableListOf(
            "Air Max 270", "Air Force 1", "Air Zoom", "Blazer Mid", "Air Vapor"
        )
        val shoesCompany = mutableListOf(
            "Nike", "Nike", "Nike", "Nike", "Nike"
        )
        val shoesSize = mutableListOf(
            "40", "43", "42", "45", "23"
        )
        val shoesDescription = mutableListOf(
            "Cool running shoes", "Casual shoes", "Comfort running shoes", "Casual shoes", "Comfort shoes"
        )

        for (i in 0 until shoesName.size){
            val shoe = Shoes()
            shoe.name = shoesName[i]
            shoe.company = shoesCompany[i]
            shoe.size = shoesSize[i]
            shoe.description = shoesDescription[i]

            _shoesList.value!! += shoe
        }
    }

    fun insertShoe (name: String, size: String, brand: String, description: String){
        val shoe = Shoes()
        shoe.name = name
        shoe.company = size
        shoe.size = brand
        shoe.description = description
        _shoesList.value!! += shoe
    }

    fun insert(){
        _shoesList.value!! += newShoe
    }
}