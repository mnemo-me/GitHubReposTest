package com.example.githubrepostest.ui.navigation

import com.example.githubrepostest.domain.entities.GitHubRepo
import com.example.githubrepostest.ui.flow.FlowFragment
import com.example.githubrepostest.ui.github_repos_details.GitHubReposDetailFragment
import com.example.githubrepostest.ui.github_repos_list.GitHubReposListFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun flowFragment() = FragmentScreen{FlowFragment()}
    fun gitHubReposList() = FragmentScreen{GitHubReposListFragment()}
    fun gitHubReposDetail(gitHubRepo: GitHubRepo) = FragmentScreen{GitHubReposDetailFragment.newInstance(gitHubRepo)}
}