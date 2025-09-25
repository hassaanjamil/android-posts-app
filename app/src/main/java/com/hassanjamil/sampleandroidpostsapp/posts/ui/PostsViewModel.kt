package com.hassanjamil.sampleandroidpostsapp.posts.ui

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hassanjamil.sampleandroidpostsapp.posts.data.Post
import com.hassanjamil.sampleandroidpostsapp.service.RetrofitClient
import kotlinx.coroutines.launch

class PostsViewModel: ViewModel() {
    private val _posts = mutableStateListOf<Post>()
    val posts: List<Post> get() = _posts

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            try {
                val fetchedPosts = RetrofitClient.apiService.getPosts()
                _posts.clear()
                _posts.addAll(fetchedPosts)
                Log.d("POSTS", "Posts fetched successfully" + fetchedPosts.size)
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }
}
