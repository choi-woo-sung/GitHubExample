package com.example.githubexample.repository

import androidx.annotation.WorkerThread
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.githubexample.model.GitHubDto
import com.example.githubexample.network.GithubService
import com.example.githubexample.paging.GitHubPagingSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class GitHubRepository @Inject constructor(
    private val githubService: GithubService,
    private val dispatcher: CoroutineDispatcher
){
    @WorkerThread
    fun fetchGitHubList(
        pageSize : Int,

    ): Flow<PagingData<GitHubDto>> {

        return Pager(
            config = PagingConfig(pageSize),
            pagingSourceFactory = { GitHubPagingSource(githubService ) }
        ).flow
    }


}