package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

    //Shoe List
    var shoeDataView = ShoeDataView()
    private val _shoeListViewData = MutableLiveData<MutableList<Shoe>>()
    val shoeListViewData: LiveData<List<ShoeDataView>>
        get() = Transformations.map(_shoeListViewData) {
            it.map { shoe -> shoe.asDataView() }
        }

    private val _eventNavigate = MutableLiveData<Boolean>()
    val eventNavigate: LiveData<Boolean>
        get() = _eventNavigate

    init {
        _shoeListViewData.value = mutableListOf()
        _eventNavigate.value = false
    }

    fun onSave() {
        _shoeListViewData.value?.add(
            shoeDataView.asShoe()
        )
        shoeDataView = ShoeDataView()
        _eventNavigate.value = true
    }

    fun onCancel() {
        _eventNavigate.value = true
    }

    fun onNavigateComplete() {
        _eventNavigate.value = false
    }
}