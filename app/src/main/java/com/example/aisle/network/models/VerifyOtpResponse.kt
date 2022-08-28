package com.example.aisle.network.models

import com.google.gson.annotations.SerializedName

data class VerifyOtpResponse (
    @SerializedName("token" ) var token : String? = null
)