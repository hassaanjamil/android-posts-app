package com.hassanjamil.sampleandroidpostsapp.data.di

import com.hassanjamil.sampleandroidpostsapp.data.repositories.PostRepositoryImpl
import com.hassanjamil.sampleandroidpostsapp.data.repositories.UserRepositoryImpl
import com.hassanjamil.sampleandroidpostsapp.domain.repository.PostRepository
import com.hassanjamil.sampleandroidpostsapp.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<PostRepository> { PostRepositoryImpl(get(), get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }
}
