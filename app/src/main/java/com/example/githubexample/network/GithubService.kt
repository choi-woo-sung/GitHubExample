package com.example.githubexample.network

import com.example.githubexample.model.GitHubResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("search/repositories")
    suspend fun searchRepos(@Query("sort") sort : String = "stars", @Query("q") search : String = "Android" , @Query("page") page: Int, @Query("per_page") perPage: Int): GitHubResponse

}