package com.hassanjamil.sampleandroidpostsapp.data.di

import com.hassanjamil.sampleandroidpostsapp.presentation.features.posts.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PostViewModel(get(), get()) }
}
