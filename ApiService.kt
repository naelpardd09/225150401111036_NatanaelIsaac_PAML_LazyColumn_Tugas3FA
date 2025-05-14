package com.example.lazycolumn  // Pastikan paketnya sesuai

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")  // Endpoint untuk mengambil daftar pengguna
    fun getUsers(): Call<List<User>>  // Mengembalikan list dari objek User
}
