package com.hassanjamil.sampleandroidpostsapp.presentation.features.home

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hassanjamil.sampleandroidpostsapp.domain.model.Post
import com.hassanjamil.sampleandroidpostsapp.domain.model.User
import com.hassanjamil.sampleandroidpostsapp.domain.usecase.GetPostsUseCase
import com.hassanjamil.sampleandroidpostsapp.domain.usecase.GetUserByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PostViewModel(
    private val getPostsUseCase: GetPostsUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase,
) : ViewModel() {
    private val _posts = mutableStateListOf<Post>()
    val posts: List<Post> get() = _posts

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user.asStateFlow()

    init {
        fetchPosts()
    }

    fun fetchPosts() {
        viewModelScope.launch {
            runCatching { getPostsUseCase() }
                .onSuccess { fetchedPosts ->
                    _posts.clear()
                    _posts.addAll(fetchedPosts)
                }
                .onFailure { it.printStackTrace() }
        }
    }

    fun updateFavoriteState(postId: Int, isFavorite: Boolean) {
        val index = _posts.indexOfFirst { it.id == postId }
        if (index >= 0) {
            val updated = _posts[index].copy(isFavorite = isFavorite)
            _posts[index] = updated
        }
    }

    fun fetchUserById(userId: Int) {
        viewModelScope.launch {
            runCatching { getUserByIdUseCase(userId) }
                .onSuccess { fetchedUser -> _user.value = fetchedUser }
                .onFailure {
                    _user.value = null
                    it.printStackTrace()
                }
        }
    }
}
