package com.example.githubexample.db

import androidx.room.Database
import com.example.githubexample.model.GitHubDetailResponse


@Database(entities = [GitHubDetailResponse::class], version = 1, exportSchema = true)
class DataBase {
    abstract fun GitHubDao(): ChampionDao
}