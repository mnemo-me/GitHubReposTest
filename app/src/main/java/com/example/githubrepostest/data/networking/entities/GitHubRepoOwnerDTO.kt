package com.example.githubrepostest.data.networking.entities

import com.example.githubrepostest.domain.entities.GitHubRepoOwner
import com.squareup.moshi.Json

data class GitHubRepoOwnerDTO (

    var login: String,

    @Json(name = "avatar_url")
    var avatarUrl : String

)

fun GitHubRepoOwnerDTO.toDomainModel() : GitHubRepoOwner{
    return GitHubRepoOwner(
        login = this.login,
        avatarUrl = this.avatarUrl
    )
}