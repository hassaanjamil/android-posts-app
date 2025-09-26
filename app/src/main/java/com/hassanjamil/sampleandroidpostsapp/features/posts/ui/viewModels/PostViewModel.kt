package com.hassanjamil.sampleandroidpostsapp.features.posts.ui.viewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hassanjamil.sampleandroidpostsapp.features.posts.data.PostRepository
import com.hassanjamil.sampleandroidpostsapp.features.posts.data.model.Post
import kotlinx.coroutines.launch

class PostViewModel(
    private val repository: PostRepository
) : ViewModel() {
    private val _posts = mutableStateListOf<Post>()
    val posts: List<Post> get() = _posts

    init {
        fetchPosts()
    }

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val fetchedPosts = repository.getPosts()
                _posts.clear()
                _posts.addAll(fetchedPosts)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
