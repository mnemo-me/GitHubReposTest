package com.example.githubrepostest.ui.github_repos_details

import com.example.githubrepostest.domain.entities.GitHubRepo
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface GitHubReposDetailView : MvpView {

    @AddToEndSingle
    fun showGitHubRepoDetails(gitHubRepo: GitHubRepo)
}