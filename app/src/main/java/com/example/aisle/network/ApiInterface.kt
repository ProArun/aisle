package com.example.aisle.network

import com.example.aisle.models.UserProfile
import com.example.aisle.network.models.GetOtpResponse
import com.example.aisle.network.models.Mobile
import com.example.aisle.network.models.Otp
import com.example.aisle.network.models.VerifyOtpResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {

    @POST("phone_number_login")
    fun getOTP(
        @Body body: Mobile
    ): Call<GetOtpResponse>


    @POST("verify_otp")
    fun verifyOtp(
        @Body body: Otp
    ): Call<VerifyOtpResponse>

    @GET("test_profile_list")
    suspend fun getUser(
        @Header("Authorization") authToken: String
    ): Response<UserProfile>

}