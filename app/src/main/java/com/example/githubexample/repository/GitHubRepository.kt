package com.example.githubexample.repository

import androidx.annotation.WorkerThread
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.githubexample.db.GithubDao
import com.example.githubexample.exceptions.EmptyBodyException
import com.example.githubexample.exceptions.NetworkFailureException
import com.example.githubexample.model.ApiResponse
import com.example.githubexample.model.GitHubDetailResponse
import com.example.githubexample.model.GitHubDto
import com.example.githubexample.network.GithubService
import com.example.githubexample.paging.GitHubPagingSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class GitHubRepository @Inject constructor(
    private val githubService: GithubService,
    private val gitHubDao: GithubDao,
    private val dispatcher: CoroutineDispatcher
) {
    @WorkerThread
    fun fetchGitHubList(
        pageSize: String,
        sort: String = "stars",
        search: String
    ): Flow<PagingData<GitHubDto>> {

        return Pager(
            config = PagingConfig(pageSize.toInt()),
            pagingSourceFactory = { GitHubPagingSource(githubService, sort, search) }
        ).flow
    }


    @WorkerThread
    suspend fun fetchGitDetail(
        fullname: String
    ): Flow<ApiResponse<GitHubDetailResponse>> = flow<ApiResponse<GitHubDetailResponse>> {
        emit(ApiResponse.Loading)

        val response = githubService.openDetail(fullname)
        if (response.isSuccessful) {
            val githubDetail: GitHubDetailResponse = response.body()
                ?: throw EmptyBodyException("[${response.code()}] - ${response.raw()}")

            gitHubDao.insertGitHubDetail(githubDetail)
            emit(ApiResponse.Success(githubDetail))

        } else {
            throw NetworkFailureException("[${response.code()}] - ${response.raw()}")
        }
    }.catch { emit(ApiResponse.Failure(it)) }
    .flowOn(dispatcher)


}




