package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

    //Shoe List
    private var _shoeList = MutableLiveData<MutableList<ShoeListFragment>>(mutableListOf())
    val shoeList: LiveData<MutableList<ShoeListFragment>>
        get() = _shoeList

    override fun onCleared() {
        super.onCleared()
    }
}