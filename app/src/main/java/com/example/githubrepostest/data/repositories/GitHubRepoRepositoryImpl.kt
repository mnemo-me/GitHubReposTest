package com.example.githubrepostest.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava3.flowable
import com.example.githubrepostest.data.networking.GitHubApi
import com.example.githubrepostest.data.networking.GitHubReposPagingSource
import com.example.githubrepostest.domain.entities.GitHubRepo
import com.example.githubrepostest.domain.repositories.GitHubRepoRepository
import io.reactivex.rxjava3.core.Flowable

class GitHubRepoRepositoryImpl() : GitHubRepoRepository {

    override fun getGitHubRepoList(keyword: String) : Flowable<PagingData<GitHubRepo>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = true, maxSize = 30, prefetchDistance = 5, initialLoadSize = 40),
            pagingSourceFactory = { GitHubReposPagingSource(GitHubApi.gitHubApiService, keyword) }
        ).flowable
    }

}