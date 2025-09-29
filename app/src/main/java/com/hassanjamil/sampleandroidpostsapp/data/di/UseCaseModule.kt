package com.hassanjamil.sampleandroidpostsapp.data.di

import com.hassanjamil.sampleandroidpostsapp.domain.usecase.GetPostsUseCase
import com.hassanjamil.sampleandroidpostsapp.domain.usecase.GetUserByIdUseCase
import com.hassanjamil.sampleandroidpostsapp.domain.usecase.GetFavoritePostsUseCase
import com.hassanjamil.sampleandroidpostsapp.domain.usecase.ToggleFavoritePostUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetPostsUseCase(get()) }
    single { GetUserByIdUseCase(get()) }
    single { GetFavoritePostsUseCase(get()) }
    single { ToggleFavoritePostUseCase(get()) }
}
