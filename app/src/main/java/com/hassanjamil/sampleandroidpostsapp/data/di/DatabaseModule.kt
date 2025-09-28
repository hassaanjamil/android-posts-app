package com.hassanjamil.sampleandroidpostsapp.data.di

import androidx.room.Room
import com.hassanjamil.sampleandroidpostsapp.data.db.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import kotlin.jvm.java

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(), // Use androidContext() for Android
            AppDatabase::class.java,
            "post_database"
        ).build()
    }

    single { get<AppDatabase>().getPostDao() } // Provide the DAO
}
