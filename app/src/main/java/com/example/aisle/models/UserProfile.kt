package com.example.aisle.models

import com.google.gson.annotations.SerializedName


data class UserProfile(

    @SerializedName("invites") var invites: Invites? = Invites(),
    @SerializedName("likes") var likes: Likes? = Likes()

)