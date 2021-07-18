package com.example.githubrepostest.ui.github_repos_list

import androidx.paging.PagingData
import com.example.githubrepostest.domain.entities.GitHubRepo
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface GitHubReposListView : MvpView {

    @AddToEndSingle
    fun showGitHubReposList(gitHubReposListPagingData: PagingData<GitHubRepo>)

    @AddToEndSingle
    fun stopRefreshingIndicator()

}