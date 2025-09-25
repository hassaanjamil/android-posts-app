package com.hassanjamil.sampleandroidpostsapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:3000/" // 10.0.2.2 points the emulator to the host machine

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
//    val apiService: ApiService by lazy {
//        retrofitClient.create(ApiService::class.java)
//    }
}
