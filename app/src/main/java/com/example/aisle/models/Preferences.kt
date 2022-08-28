package  com.example.aisle.models

import com.google.gson.annotations.SerializedName


data class Preferences(

    @SerializedName("answer_id") var answerId: Int? = null,
    @SerializedName("answer") var answer: String? = null,
    @SerializedName("first_choice") var firstChoice: String? = null,
    @SerializedName("second_choice") var secondChoice: String? = null

)