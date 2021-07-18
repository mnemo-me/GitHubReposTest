package com.example.githubrepostest.di

import android.content.Context
import com.example.githubrepostest.data.repositories.GitHubRepoRepositoryImpl
import com.example.githubrepostest.domain.repositories.GitHubRepoRepository
import com.example.githubrepostest.domain.usecases.GetGitHubReposList
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import toothpick.ktp.binding.module

fun appModule(context: Context) = module {

    bind(Context::class.java).toInstance(context)

    val cicerone = Cicerone.create()
    bind(Router::class.java).toInstance(cicerone.router)
    bind(NavigatorHolder::class.java).toInstance(cicerone.getNavigatorHolder())

    val repository = GitHubRepoRepositoryImpl()
    bind(GitHubRepoRepository::class.java).toInstance(repository)

    val getGitHubReposList = GetGitHubReposList(repository)
    bind(GetGitHubReposList::class.java).toInstance(getGitHubReposList)
}
