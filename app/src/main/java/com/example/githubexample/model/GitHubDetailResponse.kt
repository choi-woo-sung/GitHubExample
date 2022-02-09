package com.example.githubexample.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class GitHubDetailResponse (
    @SerializedName("id")
    @PrimaryKey
    val id: Long,
    @SerializedName("name") val name: String,

    @SerializedName("full_name")  val fullName: String,

//    @SerializedName("topics") val topics: List<String>,
    @SerializedName("forks")  val forks: Long,


    @SerializedName("open_issues")   val openIssues: Long,
    @SerializedName("watchers")   val watchers: Long,

//    @SerializedName("owner")  val owner: Owner,

    )

data class Owner (
    @SerializedName("id")  val id: Long
    )
