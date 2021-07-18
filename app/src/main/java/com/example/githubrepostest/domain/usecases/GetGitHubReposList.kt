package com.example.githubrepostest.domain.usecases

import com.example.githubrepostest.domain.repositories.GitHubRepoRepository
import javax.inject.Inject

class GetGitHubReposList @Inject constructor(val repository: GitHubRepoRepository) {

    operator fun invoke(keyword: String) = repository.getGitHubRepoList(keyword)
}