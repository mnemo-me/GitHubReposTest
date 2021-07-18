package com.example.githubrepostest.data.networking.entities

import com.squareup.moshi.Json

data class GetGitHubRepoListResponse (

    @Json(name = "total_count")
    var totalCount: Int,

    var items: List<GitHubRepoDTO>
)


