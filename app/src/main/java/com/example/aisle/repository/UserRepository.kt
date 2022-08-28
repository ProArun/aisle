package com.example.aisle.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.aisle.models.UserProfile
import com.example.aisle.network.ApiInterface

class UserRepository(private val apiInterface: ApiInterface) {
    private val profileLiveData = MutableLiveData<UserProfile>()

    val profileData: LiveData<UserProfile>
        get() = profileLiveData

    suspend fun getProfileData(token: String) {
        val result = apiInterface.getUser(token)
        if (result.body() != null) {
            profileLiveData.postValue(result.body())
        }
    }
}