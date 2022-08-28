package com.example.aisle.models

import com.google.gson.annotations.SerializedName


data class Profiles(
    @SerializedName("general_information") var generalInformation: GeneralInformation? = GeneralInformation(),
    @SerializedName("approved_time") var approvedTime: Double? = null,
    @SerializedName("disapproved_time") var disapprovedTime: Double? = null,
    @SerializedName("photos") var photos: ArrayList<Photos> = arrayListOf(),
    @SerializedName("user_interests") var userInterests: ArrayList<String> = arrayListOf(),
    @SerializedName("work") var work: Work? = Work(),
    @SerializedName("preferences") var preferences: ArrayList<Preferences> = arrayListOf(),
    @SerializedName("instagram_images") var instagramImages: String? = null,
    @SerializedName("last_seen_window") var lastSeenWindow: String? = null,
    @SerializedName("is_facebook_data_fetched") var isFacebookDataFetched: Boolean? = null,
    @SerializedName("icebreakers") var icebreakers: String? = null,
    @SerializedName("story") var story: String? = null,
    @SerializedName("meetup") var meetup: String? = null,
    @SerializedName("verification_status") var verificationStatus: String? = null,
    @SerializedName("has_active_subscription") var hasActiveSubscription: Boolean? = null,
    @SerializedName("show_concierge_badge") var showConciergeBadge: Boolean? = null,
    @SerializedName("lat") var lat: String? = null,
    @SerializedName("lng") var lng: String? = null,
    @SerializedName("last_seen") var lastSeen: String? = null,
    @SerializedName("online_code") var onlineCode: Int? = null,
    @SerializedName("profile_data_list") var profileDataList: ArrayList<ProfileDataList> = arrayListOf()

)