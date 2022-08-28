package com.example.aisle.models

import com.google.gson.annotations.SerializedName


data class Invites(
    @SerializedName("profiles") var profiles: ArrayList<Profiles> = arrayListOf(),
    @SerializedName("totalPages") var totalPages: Int? = null,
    @SerializedName("pending_invitations_count") var pendingInvitationsCount: Int? = null
)