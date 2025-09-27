package com.hassanjamil.sampleandroidpostsapp.presentation.features.posts

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hassanjamil.sampleandroidpostsapp.data.model.Post
import com.hassanjamil.sampleandroidpostsapp.data.model.User
import com.hassanjamil.sampleandroidpostsapp.data.repositories.PostRepository
import com.hassanjamil.sampleandroidpostsapp.data.repositories.UserRepository
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
