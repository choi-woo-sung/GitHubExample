package com.example.githubexample.db

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.githubexample.model.GitHubDetailResponse

interface GitHubDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGitHubDetail(gitHubDetailResponse: GitHubDetailResponse)

    @Query("SELECT * FROM Repo")
    suspend fun getGitHubDetail(): GitHubDetailResponse

}