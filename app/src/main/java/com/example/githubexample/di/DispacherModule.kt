package com.example.githubexample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
class DispacherModule {

    @Provides
    @ViewModelScoped
    fun provideIODispatcher(): CoroutineDispatcher{
        return Dispatchers.IO
    }
}