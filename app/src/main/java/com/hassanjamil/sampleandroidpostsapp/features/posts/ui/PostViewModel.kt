package com.hassanjamil.sampleandroidpostsapp.features.posts.ui

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hassanjamil.sampleandroidpostsapp.features.posts.data.serializables.Post
import com.hassanjamil.sampleandroidpostsapp.features.posts.data.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    @Suppress("unused") private val _savedStateHandle: SavedStateHandle,
    private val repository: PostRepository
): ViewModel() {
    private val _posts = mutableStateListOf<Post>()
    val posts: List<Post> get() = _posts

    init {
        fetchPosts()
    }

    fun fetchPosts() {
//        return repository.getPosts();
        viewModelScope.launch {
            try {
                val fetchedPosts = repository.getPosts()
                _posts.clear()
                _posts.addAll(fetchedPosts)
                Log.d("POSTS", "Posts fetched successfully " + fetchedPosts.size)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
