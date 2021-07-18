package com.example.githubrepostest.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitHubRepo (

    var id: Long,

    var name: String,

    var owner: GitHubRepoOwner,

    var description: String,

    var forksCount: Long,

    var starsCount: Long,

    var createdAt: String
) : Parcelable