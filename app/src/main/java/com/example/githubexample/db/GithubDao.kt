package com.example.githubexample.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.githubexample.model.GitHubDetailResponse

@Dao
interface GithubDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGitHubDetail(gitHubDetailResponse: GitHubDetailResponse)

    @Query("SELECT * FROM GitHubDetailResponse")
    suspend fun getGitHubDetail(): GitHubDetailResponse

}