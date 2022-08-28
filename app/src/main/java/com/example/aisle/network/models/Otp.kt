package com.example.aisle.network.models

import com.google.gson.annotations.SerializedName

data class Otp (
    @SerializedName("number" ) var number : String? = null,
    @SerializedName("otp"    ) var otp    : String? = null
)