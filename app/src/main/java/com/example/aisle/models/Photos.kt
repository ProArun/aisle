package  com.example.aisle.models

import com.google.gson.annotations.SerializedName


data class Photos(

    @SerializedName("photo") var photo: String? = null,
    @SerializedName("photo_id") var photoId: Int? = null,
    @SerializedName("selected") var selected: Boolean? = null,
    @SerializedName("status") var status: String? = null

)