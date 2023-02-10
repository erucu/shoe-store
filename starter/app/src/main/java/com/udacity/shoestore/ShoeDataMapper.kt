package com.udacity.shoestore

object ShoeDataMapper {

    fun mapToViewData(shoe: Shoe) =
        ShoeDataView(
            shoeName = shoe.shoeName,
            shoeCompany = shoe.shoeCompany,
            shoeSize = shoe.shoeSize.toString(),
            shoeDescription = shoe.shoeDescription
        )

    fun mapFromViewData(
        shoe: ShoeDataView
    ) = ShoeDataView(
        shoeName = shoe.shoeName.ifEmpty { "Empty Name" },
        shoeCompany = shoe.shoeCompany.ifEmpty { "Company Name" },
        shoeSize = shoe.shoeSize.ifEmpty { "0" }.toString(),
        shoeDescription = shoe.shoeDescription
    )
}