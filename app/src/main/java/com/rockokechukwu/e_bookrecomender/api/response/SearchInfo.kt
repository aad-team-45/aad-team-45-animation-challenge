package com.rockokechukwu.e_bookrecomender.api.response

import com.google.gson.annotations.SerializedName

data class SearchInfo (

    @SerializedName("textSnippet") val textSnippet : String
)