package com.example.aisle.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aisle.repository.UserRepository


class ViewModelFactory(
    private val repository: UserRepository,
    private val token: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(repository, token) as T
    }
}