package com.example.shopapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.shopapp.network.User
import com.example.shopapp.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private val userViewModel = UserViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        fetchUserData()
    }

    private fun fetchUserData() {
        userViewModel.fetchUsers { userList ->
            if (userList.isNotEmpty()) {
                Toast.makeText(
                    this,
                    "Fetched ${userList.size} users",
                    Toast.LENGTH_SHORT
                ).show()

                userList.forEach {
                    println("User Name: ${it.name}")
                }
            } else {
                Toast.makeText(this, "No users fetched", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
