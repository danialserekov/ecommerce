package com.example.shopapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.network.RetrofitClient
import com.example.shopapp.network.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel : ViewModel() {

    var userList: List<User> = listOf()

    fun fetchUsers(onResult: (List<User>) -> Unit) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    userList = RetrofitClient.apiService.getUsers()
                    withContext(Dispatchers.Main) {
                        onResult(userList)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}
