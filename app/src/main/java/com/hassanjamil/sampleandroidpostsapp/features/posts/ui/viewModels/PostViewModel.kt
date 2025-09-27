package com.hassanjamil.sampleandroidpostsapp.features.posts.ui.viewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hassanjamil.sampleandroidpostsapp.features.posts.data.PostRepository
import com.hassanjamil.sampleandroidpostsapp.features.posts.data.UserRepository
import com.hassanjamil.sampleandroidpostsapp.features.posts.data.model.Post
import com.hassanjamil.sampleandroidpostsapp.features.posts.data.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PostViewModel(
    private val postRepos: PostRepository,
    private val userRepos: UserRepository,
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
            try {
                val fetchedPosts = postRepos.getPosts()
                _posts.clear()
                _posts.addAll(fetchedPosts)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun fetchUserById(userId: Int) {
        viewModelScope.launch {
            try {
                _user.value = null
                val fetchedUser = userRepos.getUserById(userId)
                _user.value = fetchedUser
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
