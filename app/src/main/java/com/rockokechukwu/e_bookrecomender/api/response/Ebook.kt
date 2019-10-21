package com.rockokechukwu.e_bookrecomender.api.response

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.rockokechukwu.e_bookrecomender.db.IndustryIdentifiersConverter
import com.rockokechukwu.e_bookrecomender.db.OtherTypeConverter

@Entity(primaryKeys = ["id"])
@TypeConverters(IndustryIdentifiersConverter::class, OtherTypeConverter::class)
data class Ebook (

    @field:SerializedName("kind") val kind : String,
    @field:SerializedName("id") val id : String,
    @field:SerializedName("etag") val etag : String,
    @field:SerializedName("selfLink") val selfLink : String,
    @field:SerializedName("volumeInfo")
    @field:Embedded val volumeInfo : VolumeInfo,
    @SerializedName("saleInfo")
    @field:Embedded val saleInfo : SaleInfo,
    @SerializedName("accessInfo")
    @field:Embedded val accessInfo : AccessInfo,
    @SerializedName("searchInfo")
    @field:Embedded val searchInfo : SearchInfo
){
    data class VolumeInfo (

        @field:SerializedName("title") val title : String,
        @field:SerializedName("authors") val authors : List<String>,
        @field:SerializedName("publishedDate") val publishedDate : Int,
        @field:SerializedName("industryIdentifiers") val industryIdentifiers : MutableList<IndustryIdentifiers>,
        @field:SerializedName("readingModes")
        @field:Embedded val readingModes : ReadingModes,
        @field:SerializedName("pageCount") val pageCount : Int,
        @field:SerializedName("printType") val printType : String,
        @field:SerializedName("categories") val categories : MutableList<String>,
        @field:SerializedName("maturityRating") val maturityRating : String,
        @field:SerializedName("allowAnonLogging") val allowAnonLogging : Boolean,
        @field:SerializedName("contentVersion") val contentVersion : String,
        @field:SerializedName("imageLinks")
        @field:Embedded val imageLinks : ImageLinks,
        @field:SerializedName("language") val language : String,
        @field:SerializedName("previewLink") val previewLink : String,
        @field:SerializedName("infoLink") val infoLink : String,
        @field:SerializedName("canonicalVolumeLink") val canonicalVolumeLink : String
    ){
        data class IndustryIdentifiers (

            @SerializedName("type") val type : String,
            @SerializedName("identifier") val identifier : String
        )

        data class ReadingModes (

            @SerializedName("text") val text : Boolean,
            @SerializedName("image") val image : Boolean
        )
    }
}