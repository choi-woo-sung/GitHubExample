package com.example.githubexample.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.githubexample.model.GitHubDto
import com.example.githubexample.network.GithubService


class GitHubPagingSource(
    private val gitHubService: GithubService,
    private val sort: String,
    private val search: String
) : PagingSource<Int, GitHubDto>() {
    override fun getRefreshKey(state: PagingState<Int, GitHubDto>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GitHubDto> {
        return try {
            val page = params.key ?: 1 // 처음은 1
            val pageSize = params.loadSize
            val repoResponse = gitHubService.searchRepos(
                sort = sort,
                search = search,
                page = page,
                perPage = pageSize
            )
            val repoItems = repoResponse.items
            val prevKey = if (page > 1) page - 1 else null
            val nextKey = if (repoItems.isNotEmpty()) page + 1 else null
            LoadResult.Page(repoItems, prevKey, nextKey)
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }

}