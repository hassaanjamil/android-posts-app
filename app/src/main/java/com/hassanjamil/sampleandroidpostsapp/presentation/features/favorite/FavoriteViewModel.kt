package com.hassanjamil.sampleandroidpostsapp.presentation.features.favorite

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hassanjamil.sampleandroidpostsapp.data.db.PostDao
import com.hassanjamil.sampleandroidpostsapp.data.model.Post
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val postDao: PostDao,
) : ViewModel() {

    private val _favPosts = mutableStateListOf<Post>()
    val favPosts: List<Post> get() = _favPosts

    init {
        getFavoritePosts()
    }

    fun toggleFavoritePost(post: Post) {
        viewModelScope.launch {
            val found = favPosts.find { item -> item.id == post.id }
            post.isFavorite = true
            if(found == null)
                postDao.insert(post)
            else
                postDao.deletePostById(post.id)
        }
    }

    fun getFavoritePosts() {
        viewModelScope.launch {
            val favoritePosts = postDao.getFavoritePosts()
            _favPosts.clear()
            _favPosts.addAll(favoritePosts)
        }
    }
}
