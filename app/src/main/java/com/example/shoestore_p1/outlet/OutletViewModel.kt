package com.example.shoestore_p1.outlet

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore_p1.Shoes
import kotlin.math.log

class OutletViewModel: ViewModel() {

    private var _shoesList = MutableLiveData<MutableList<Shoes>>()
    val shoesList: LiveData<MutableList<Shoes>>
        get() = _shoesList

    init {
        Log.i("ViewModel", "init")
        insertInitialData()
    }

    private fun insertInitialData () {
        _shoesList.value = mutableListOf()
        val shoesName = mutableListOf(
            "dummy1", "dummy2", "dummy3", "dummy4", "dummy5"
        )
        val shoesCompany = mutableListOf(
            "Dummy1", "Dummy2", "Dummy3", "Dummy4", "Dummy5"
        )
        val shoesSize = mutableListOf(
            "DuMmy1", "DuMmy2", "DuMmy3", "DuMmy4", "DuMmy5"
        )
        val shoesDescription = mutableListOf(
            "DuMmy1", "DuMmy2", "DuMmy3", "DuMmy4", "DuMmy5"
        )

        for (i in 0 until shoesName.size){
            val shoe = Shoes(shoesName[i],shoesCompany[i], shoesSize[i], shoesDescription[i])
            _shoesList.value!! += shoe
        }
    }

    fun insertShoe (name: String, size: String, brand: String, description: String){
        val shoe = Shoes(name, size, brand, description)
        _shoesList.value!! += shoe
    }
}