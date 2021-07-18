package com.example.githubrepostest.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitHubRepoOwner(
    var login: String,

    var avatarUrl : String
) : Parcelable
