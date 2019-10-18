package com.rockokechukwu.e_bookrecomender.api.response

import IndustryIdentifiers
import ReadingModes
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(primaryKeys = ["id"])
data class Ebook (

    @field:SerializedName("kind") val kind : String,
    @field:SerializedName("id") val id : String,
    @field:SerializedName("etag") val etag : String,
    @field:SerializedName("selfLink") val selfLink : String,
    @field:SerializedName("volumeInfo") val volumeInfo : VolumeInfo,
    @field:SerializedName("saleInfo") val saleInfo : SaleInfo,
    @field:SerializedName("accessInfo") val accessInfo : AccessInfo,
    @field:SerializedName("searchInfo") val searchInfo : SearchInfo
){
    data class VolumeInfo (

        @field:SerializedName("title") val title : String,
        @field:SerializedName("authors") val authors : List<String>,
        @field:SerializedName("publishedDate") val publishedDate : Int,
        @field:SerializedName("industryIdentifiers") val industryIdentifiers : List<IndustryIdentifiers>,
        @field:SerializedName("readingModes") val readingModes : ReadingModes,
        @field:SerializedName("pageCount") val pageCount : Int,
        @field:SerializedName("printType") val printType : String,
        @field:SerializedName("categories") val categories : List<String>,
        @field:SerializedName("maturityRating") val maturityRating : String,
        @field:SerializedName("allowAnonLogging") val allowAnonLogging : Boolean,
        @field:SerializedName("contentVersion") val contentVersion : String,
        @field:SerializedName("imageLinks") val imageLinks : ImageLinks,
        @field:SerializedName("language") val language : String,
        @field:SerializedName("previewLink") val previewLink : String,
        @field:SerializedName("infoLink") val infoLink : String,
        @field:SerializedName("canonicalVolumeLink") val canonicalVolumeLink : String
    )
}