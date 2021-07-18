package com.example.githubrepostest.data.networking

import com.example.githubrepostest.data.networking.entities.GetGitHubRepoListResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GitHubApiService {

    @GET("search/repositories")
    fun getGitHubReposList(@Query("q") keyword : String, @Query("page") page: Int) : Single<GetGitHubRepoListResponse>
}


// @Query("per_page") size: Int

