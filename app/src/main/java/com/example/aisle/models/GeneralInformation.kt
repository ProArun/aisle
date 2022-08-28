package com.example.aisle.models

import com.google.gson.annotations.SerializedName


data class GeneralInformation(

    @SerializedName("date_of_birth") var dateOfBirth: String? = null,
    @SerializedName("date_of_birth_v1") var dateOfBirthV1: String? = null,
    @SerializedName("location") var location: Location? = Location(),
    @SerializedName("drinking_v1") var drinkingV1: DrinkingV1? = DrinkingV1(),
    @SerializedName("first_name") var firstName: String? = null,
    @SerializedName("gender") var gender: String? = null,
    @SerializedName("marital_status_v1") var maritalStatusV1: MaritalStatusV1? = MaritalStatusV1(),
    @SerializedName("ref_id") var refId: String? = null,
    @SerializedName("smoking_v1") var smokingV1: SmokingV1? = SmokingV1(),
    @SerializedName("sun_sign_v1") var sunSignV1: SunSignV1? = SunSignV1(),
    @SerializedName("mother_tongue") var motherTongue: MotherTongue? = MotherTongue(),
    @SerializedName("faith") var faith: Faith? = Faith(),
    @SerializedName("height") var height: Int? = null,
    @SerializedName("cast") var cast: String? = null,
    @SerializedName("kid") var kid: String? = null,
    @SerializedName("diet") var diet: String? = null,
    @SerializedName("politics") var politics: String? = null,
    @SerializedName("pet") var pet: String? = null,
    @SerializedName("settle") var settle: String? = null,
    @SerializedName("mbti") var mbti: String? = null,
    @SerializedName("age") var age: Int? = null

)