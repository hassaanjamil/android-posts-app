package com.hassanjamil.sampleandroidpostsapp.di

import com.hassanjamil.sampleandroidpostsapp.features.posts.ui.viewModels.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PostViewModel(get()) }
}
