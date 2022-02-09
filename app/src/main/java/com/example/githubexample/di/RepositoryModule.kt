package com.example.githubexample.di

import com.example.githubexample.db.GithubDao
import com.example.githubexample.network.GithubService
import com.example.githubexample.repository.GitHubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideGithubRepository(
        GithubService: GithubService,
        githubDao: GithubDao,
        dispatcher: CoroutineDispatcher
    ): GitHubRepository {
        return GitHubRepository(GithubService, githubDao, dispatcher)
    }

}