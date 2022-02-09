package com.example.githubexample.model

import com.google.gson.annotations.SerializedName


/**
 * Item을 감싸고 있는 DataClass
 */
data class GitHubResponse(
    @SerializedName("items") val items: List<GitHubDto> = emptyList()
)

data class GitHubDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String?,
    @SerializedName("stargazers_count") val starCount: Int,
    @SerializedName("full_name") val fullName: String
)

