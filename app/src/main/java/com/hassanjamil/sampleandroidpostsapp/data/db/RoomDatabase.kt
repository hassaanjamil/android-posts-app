package com.hassanjamil.sampleandroidpostsapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hassanjamil.sampleandroidpostsapp.data.model.Post

@TypeConverters(PostTypeConverter::class)
@Database(version = 1, entities = [Post::class], exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getPostDao(): PostDao
}
