package com.hassanjamil.sampleandroidpostsapp.di

import com.hassanjamil.sampleandroidpostsapp.features.posts.data.PostRepository
import com.hassanjamil.sampleandroidpostsapp.features.posts.data.PostRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<PostRepository> { PostRepositoryImpl(get()) }
}
