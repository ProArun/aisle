package com.example.aisle.models

import com.google.gson.annotations.SerializedName


data class Likes(
    @SerializedName("profiles") var profileOfUsers: ArrayList<ProfileOfUsers> = arrayListOf(),
    @SerializedName("can_see_profile") var canSeeProfile: Boolean? = null,
    @SerializedName("likes_received_count") var likesReceivedCount: Int? = null
)