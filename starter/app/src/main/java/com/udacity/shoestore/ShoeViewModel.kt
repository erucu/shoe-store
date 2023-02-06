package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

    //Shoe List
    var shoeDataView = Shoe()
    private val _shoeListViewData = MutableLiveData<MutableList<Shoe>>()
    val shoeListViewData: LiveData<List<Shoe>>
        get() = Transformations.map(_shoeListViewData) {
            it.map { shoe -> ShoeDataMapper.mapToViewData(shoe) }
        }

    private val _eventNavigate = MutableLiveData<Boolean>()
    val eventNavigate: LiveData<Boolean>
        get() = _eventNavigate

    init {
        _shoeListViewData.value = mutableListOf()
        _eventNavigate.value = false
    }
}