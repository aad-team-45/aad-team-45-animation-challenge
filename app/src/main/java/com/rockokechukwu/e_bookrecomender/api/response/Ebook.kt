package com.rockokechukwu.e_bookrecomender.api.response

import IndustryIdentifiers
import ReadingModes
import com.google.gson.annotations.SerializedName

data class Items (

    @SerializedName("kind") val kind : String,
    @SerializedName("id") val id : String,
    @SerializedName("etag") val etag : String,
    @SerializedName("selfLink") val selfLink : String,
    @SerializedName("volumeInfo") val volumeInfo : VolumeInfo,
    @SerializedName("saleInfo") val saleInfo : SaleInfo,
    @SerializedName("accessInfo") val accessInfo : AccessInfo,
    @SerializedName("searchInfo") val searchInfo : SearchInfo
){
    data class VolumeInfo (

        @SerializedName("title") val title : String,
        @SerializedName("authors") val authors : List<String>,
        @SerializedName("publishedDate") val publishedDate : Int,
        @SerializedName("industryIdentifiers") val industryIdentifiers : List<IndustryIdentifiers>,
        @SerializedName("readingModes") val readingModes : ReadingModes,
        @SerializedName("pageCount") val pageCount : Int,
        @SerializedName("printType") val printType : String,
        @SerializedName("categories") val categories : List<String>,
        @SerializedName("maturityRating") val maturityRating : String,
        @SerializedName("allowAnonLogging") val allowAnonLogging : Boolean,
        @SerializedName("contentVersion") val contentVersion : String,
        @SerializedName("imageLinks") val imageLinks : ImageLinks,
        @SerializedName("language") val language : String,
        @SerializedName("previewLink") val previewLink : String,
        @SerializedName("infoLink") val infoLink : String,
        @SerializedName("canonicalVolumeLink") val canonicalVolumeLink : String
    )
}