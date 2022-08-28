package com.example.aisle.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aisle.models.UserProfile
import com.example.aisle.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository,
    private val token: String
) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getProfileData(token)
        }
    }

    val profileData: LiveData<UserProfile>
        get() = repository.profileData

}