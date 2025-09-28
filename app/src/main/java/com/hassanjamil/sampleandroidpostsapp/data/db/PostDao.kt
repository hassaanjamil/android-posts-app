package com.hassanjamil.sampleandroidpostsapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hassanjamil.sampleandroidpostsapp.data.model.Post

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(post: Post)

    @Query("Select * From Post Where id = :id")
    suspend fun getPostById(id: Int): Post?

    @Query("DELETE FROM Post WHERE id = :id")
    suspend fun deletePostById(id: Int)

    @Query("SELECT * FROM Post")
    suspend fun getAllPosts(): List<Post?>
}
