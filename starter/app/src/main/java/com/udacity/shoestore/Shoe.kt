package com.udacity.shoestore

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var shoeName: String,
    var shoeSize: Int,
    var shoeCompany: String,
    var shoeDescription: String,
) : Parcelable
