package com.example.githubrepostest.data.networking.entities

import com.example.githubrepostest.domain.entities.GitHubRepo
import com.squareup.moshi.Json

data class GitHubRepoDTO(

    var id: Long,

    var name: String,

    var owner: GitHubRepoOwnerDTO,

    var description: String,

    @Json(name = "forks_count")
    var forksCount: Long,

    @Json(name = "stargazers_count")
    var starsCount: Long,

    @Json(name = "created_at")
    var createdAt: String

)

fun GitHubRepoDTO.asDomainModel() : GitHubRepo{
    return GitHubRepo(
        id = this.id,
        name = this.name,
        owner = this.owner.toDomainModel(),
        description = this.description,
        forksCount = this.forksCount,
        starsCount = this.starsCount,
        createdAt = this.createdAt
    )
}

fun List<GitHubRepoDTO>.asDomainModel() : List<GitHubRepo> = map { it.asDomainModel() }
