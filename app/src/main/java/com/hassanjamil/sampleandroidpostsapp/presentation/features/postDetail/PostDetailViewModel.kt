package com.hassanjamil.sampleandroidpostsapp.presentation.features.postDetail

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hassanjamil.sampleandroidpostsapp.data.mapper.toData
import com.hassanjamil.sampleandroidpostsapp.data.model.Comment
import com.hassanjamil.sampleandroidpostsapp.domain.usecase.GetCommentsUseCase
import kotlinx.coroutines.launch

class PostDetailViewModel(
    private val getCommentsUseCase: GetCommentsUseCase
) : ViewModel() {
    private val _comments = mutableStateListOf<Comment>()
    val comments: List<Comment> get() = _comments

    fun getComments(postId: Int) {
        viewModelScope.launch {
            val comments = getCommentsUseCase(postId).map { it.toData() }
            Log.i("COMMENTS", comments.toString())
            _comments.clear()
            _comments.addAll(comments)
        }
    }
}
