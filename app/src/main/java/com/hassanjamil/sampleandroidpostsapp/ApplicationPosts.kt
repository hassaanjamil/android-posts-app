package com.hassanjamil.sampleandroidpostsapp

import android.app.Application
import com.hassanjamil.sampleandroidpostsapp.di.networkModule
import com.hassanjamil.sampleandroidpostsapp.di.repositoryModule
import com.hassanjamil.sampleandroidpostsapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ApplicationPosts : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@ApplicationPosts)
            modules(
                networkModule,
                repositoryModule,
                viewModelModule
            )
        }
    }
}
