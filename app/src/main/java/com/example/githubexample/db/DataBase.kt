package com.example.githubexample.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.githubexample.model.GitHubDetailResponse


@Database(entities = [GitHubDetailResponse::class], version = 1, exportSchema = true)
abstract class DataBase  : RoomDatabase() {
    abstract fun GitHubDao(): GithubDao
}