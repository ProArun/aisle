package  com.example.aisle.models

import com.google.gson.annotations.SerializedName


data class PreferenceQuestion(

    @SerializedName("first_choice") var firstChoice: String? = null,
    @SerializedName("second_choice") var secondChoice: String? = null

)