package com.example.lazycolumn  // Menyesuaikan dengan paket di folder 'network'

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// RetrofitClient object untuk menangani konfigurasi Retrofit
object RetrofitClient {

    // URL dasar untuk API
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    // Menyediakan instance dari ApiService
    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)  // Menentukan URL dasar API
            .addConverterFactory(GsonConverterFactory.create())  // Menggunakan Gson untuk mengonversi JSON ke objek Kotlin
            .build()
            .create(ApiService::class.java)  // Membuat instansi dari ApiService
    }
}
