package com.hassanjamil.sampleandroidpostsapp.data.di

import com.hassanjamil.sampleandroidpostsapp.presentation.features.favorite.FavoriteViewModel
import com.hassanjamil.sampleandroidpostsapp.presentation.features.home.PostViewModel
import com.hassanjamil.sampleandroidpostsapp.presentation.features.postDetail.PostDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PostViewModel(get(), get()) }
    viewModel { FavoriteViewModel(get(), get()) }
    viewModel { PostDetailViewModel(get()) }
}
