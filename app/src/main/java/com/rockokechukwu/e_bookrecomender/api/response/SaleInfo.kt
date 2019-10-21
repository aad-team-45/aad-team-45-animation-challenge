package com.rockokechukwu.e_bookrecomender.api.response

import com.google.gson.annotations.SerializedName

data class SaleInfo (

    @SerializedName("country") val saleCountry : String,
    @SerializedName("saleability") val saleability : String,
    @SerializedName("isEbook") val isEbook : Boolean,
    @SerializedName("buyLink") val buyLink : String
)