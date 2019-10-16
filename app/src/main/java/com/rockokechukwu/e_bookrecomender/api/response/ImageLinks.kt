package com.rockokechukwu.e_bookrecomender.api.response

import com.google.gson.annotations.SerializedName

data class ImageLinks (

    @SerializedName("smallThumbnail") val smallThumbnail : String,
    @SerializedName("thumbnail") val thumbnail : String
)