package com.example.aisle.models

import com.google.gson.annotations.SerializedName


data class Location(

    @SerializedName("summary") var summary: String? = null,
    @SerializedName("full") var full: String? = null

)