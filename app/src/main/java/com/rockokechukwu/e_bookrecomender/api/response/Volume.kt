package com.rockokechukwu.e_bookrecomender.api.response

import com.google.gson.annotations.SerializedName

data class Volume(

    @SerializedName("kind") val kind : String,
    @SerializedName("totalItems") val totalItems : Int,
    @SerializedName("items") val items : List<Ebook>
)