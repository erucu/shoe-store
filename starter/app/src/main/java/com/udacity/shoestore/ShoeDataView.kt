package com.udacity.shoestore

data class ShoeDataView(
    var shoeName: String = "",
    var shoeCompany: String = "",
    var shoeSize: String = "",
    var shoeDescription: String = ""
)

fun ShoeDataView.asShoe(): Shoe = Shoe(
    shoeName = shoeName.ifEmpty { "Empty Name" },
    shoeCompany = shoeCompany.ifEmpty { "Company Name" },
    shoeSize = shoeSize.ifEmpty { "0" }.toInt(),
    shoeDescription = shoeDescription
)

