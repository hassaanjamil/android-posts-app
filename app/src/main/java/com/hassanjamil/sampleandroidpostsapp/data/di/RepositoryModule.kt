package com.hassanjamil.sampleandroidpostsapp.data.di

import com.hassanjamil.sampleandroidpostsapp.data.repositories.PostRepository
import com.hassanjamil.sampleandroidpostsapp.data.repositories.PostRepositoryImpl
import com.hassanjamil.sampleandroidpostsapp.data.repositories.UserRepository
import com.hassanjamil.sampleandroidpostsapp.data.repositories.UserRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<PostRepository> { PostRepositoryImpl(get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }
}
