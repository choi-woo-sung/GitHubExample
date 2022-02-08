package com.example.githubexample

import android.app.Application
import com.example.githubexample.timber.LineNumberDebugTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class GitHubApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(LineNumberDebugTree())
    }
}