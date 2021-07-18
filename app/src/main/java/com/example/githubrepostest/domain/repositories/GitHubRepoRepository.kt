package com.example.githubrepostest.domain.repositories

import androidx.paging.PagingData
import com.example.githubrepostest.domain.entities.GitHubRepo
import io.reactivex.rxjava3.core.Flowable

interface GitHubRepoRepository {

    fun getGitHubRepoList(keyword: String) : Flowable<PagingData<GitHubRepo>>
}