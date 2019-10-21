package com.rockokechukwu.e_bookrecomender.api.response

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class AccessInfo (

    @SerializedName("country") val accessCountry : String,
    @SerializedName("viewability") val viewability : String,
    @SerializedName("embeddable") val embeddable : Boolean,
    @SerializedName("publicDomain") val publicDomain : Boolean,
    @SerializedName("textToSpeechPermission") val textToSpeechPermission : String,
    @SerializedName("epub")
    @field:Embedded val epub : Epub,
    @SerializedName("pdf")
    @field:Embedded val pdf : Pdf,
    @SerializedName("webReaderLink") val webReaderLink : String,
    @SerializedName("accessViewStatus") val accessViewStatus : String,
    @SerializedName("quoteSharingAllowed") val quoteSharingAllowed : Boolean
){
    data class Epub (

        @SerializedName("isAvailable") val epubisAvailable : Boolean,
        @SerializedName("downloadLink") val epubDownloadLink : String
    )

    data class Pdf (

        @SerializedName("isAvailable") val pdfIsAvailable : Boolean,
        @SerializedName("downloadLink") val pdfDownloadLink : String
    )
}