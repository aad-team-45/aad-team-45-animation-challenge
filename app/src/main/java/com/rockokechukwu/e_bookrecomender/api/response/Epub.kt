import com.google.gson.annotations.SerializedName


data class Epub (

    @SerializedName("isAvailable") val isAvailable : Boolean,
    @SerializedName("downloadLink") val downloadLink : String
)