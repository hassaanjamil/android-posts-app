package com.hassanjamil.sampleandroidpostsapp.di

import com.hassanjamil.sampleandroidpostsapp.service.ApiService
import com.hassanjamil.sampleandroidpostsapp.service.RetrofitClient
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    single<Retrofit> { RetrofitClient.retrofit }
    single<ApiService> { get<Retrofit>().create(ApiService::class.java) }
}
