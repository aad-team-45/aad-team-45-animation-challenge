package com.rockokechukwu.e_bookrecomender.api.response

import IndustryIdentifiers
import ReadingModes
import com.google.gson.annotations.SerializedName

data class Volume<T>(

    @SerializedName("kind") val kind : String,
    @SerializedName("totalItems") val totalItems : Int,
    @SerializedName("items") val items : List<Items>
)