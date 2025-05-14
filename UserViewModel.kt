package com.example.lazycolumn

import androidx.lifecycle.ViewModel
import com.example.lazycolumn.RetrofitClient
import com.example.lazycolumn.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.compose.runtime.mutableStateListOf

class UserViewModel : ViewModel() {
    // mutableStateListOf akan menyimpan data secara langsung
    var users = mutableStateListOf<User>()
        private set

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        RetrofitClient.apiService.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    users.clear()
                    users.addAll(response.body() ?: emptyList())

                    // Log untuk memastikan data diterima
                    println("Users received: ${response.body()}")
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                // Menangani kesalahan jika pengambilan data gagal
                println("Error fetching users: ${t.message}")
            }
        })
    }
}

