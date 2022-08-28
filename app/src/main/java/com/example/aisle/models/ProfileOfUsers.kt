package com.example.aisle.models

import com.google.gson.annotations.SerializedName


data class ProfileOfUsers(
    @SerializedName("first_name") var firstName: String? = null,
    @SerializedName("avatar") var avatar: String? = null
)