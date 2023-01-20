package com.udacity.shoestore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.data.model.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()

    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = mutableListOf(
            Shoe("Nike Air Max 90", 10.0, "Nike", "A true classic in black and white"),
            Shoe("Adidas Samba", 9.0, "Adidas", "Iconic soccer shoe"),
            Shoe("Puma Cleats", 10.5, "Puma", "Puma soccer cleats"),
            Shoe("New Balance Shoes", 13.0, "New Balance", "A style for any age"),
            Shoe("Brooks Ghost", 8.0, "Brooks", "The popular running shoe"),
            Shoe("Nike Zoom", 7.5, "Nike", "Lightweight shoe"),
            Shoe("UA Basketball shoe", 12.0, "Under Armour", "High upper for ankle support"),
            Shoe("Reebok Baseball Cleats", 10.0, "Reebok", "Cleats for the diamond"),
        )
    }

    fun addShoe(shoe: Shoe){
        _shoeList.value?.add(shoe)
    }
}
