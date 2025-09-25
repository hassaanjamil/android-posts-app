package com.hassanjamil.sampleandroidpostsapp.di

import com.hassanjamil.sampleandroidpostsapp.features.posts.data.PostRepository
import com.hassanjamil.sampleandroidpostsapp.features.posts.data.PostRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
@Suppress("unused")
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMyRepository(
        myRepositoryImpl: PostRepositoryImpl
    ): PostRepository
}
