package com.example.githubrepostest.data.networking

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import com.example.githubrepostest.data.networking.entities.GetGitHubRepoListResponse
import com.example.githubrepostest.data.networking.entities.asDomainModel
import com.example.githubrepostest.domain.entities.GitHubRepo
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GitHubReposPagingSource(private val gitHubApiService: GitHubApiService, private val keyword: String) : RxPagingSource<Int, GitHubRepo>() {

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, GitHubRepo>> {

        val position = params.key ?: 1

        return gitHubApiService.getGitHubReposList(keyword, position)
            .subscribeOn(Schedulers.io())
            .map { response -> toLoadResult(response, position)}
            .onErrorReturn { LoadResult.Error(it) }
    }

    private fun toLoadResult(response : GetGitHubRepoListResponse, position: Int) : LoadResult<Int, GitHubRepo>{
        return LoadResult.Page(
            data = response.items.asDomainModel(),
            prevKey = if (position == 1) null else position - 1,
            nextKey = if (position == response.totalCount) null else position + 1
        )
    }

    override fun getRefreshKey(state: PagingState<Int, GitHubRepo>): Int? {
        TODO("Not yet implemented")
    }
}