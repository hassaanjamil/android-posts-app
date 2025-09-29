package com.hassanjamil.sampleandroidpostsapp.presentation.features.favorite

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hassanjamil.sampleandroidpostsapp.domain.model.Post
import com.hassanjamil.sampleandroidpostsapp.domain.usecase.GetFavoritePostsUseCase
import com.hassanjamil.sampleandroidpostsapp.domain.usecase.ToggleFavoritePostUseCase
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val getFavoritePostsUseCase: GetFavoritePostsUseCase,
    private val toggleFavoritePostUseCase: ToggleFavoritePostUseCase,
) : ViewModel() {

    private val _favPosts = mutableStateListOf<Post>()
    val favPosts: List<Post> get() = _favPosts

    init {
        getFavoritePosts()
    }

    fun toggleFavoritePost(post: Post) {
        viewModelScope.launch {
            toggleFavoritePostUseCase(post, post.isFavorite)
            getFavoritePosts()
        }
    }

    fun getFavoritePosts() {
        viewModelScope.launch {
            val favoritePosts = getFavoritePostsUseCase()
            _favPosts.clear()
            _favPosts.addAll(favoritePosts)
        }
    }
}
