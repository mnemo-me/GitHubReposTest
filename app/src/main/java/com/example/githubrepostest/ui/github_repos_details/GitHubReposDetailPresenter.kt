package com.example.githubrepostest.ui.github_repos_details

import com.example.githubrepostest.di.Scopes
import com.example.githubrepostest.ui.navigation.Screens
import com.github.terrakok.cicerone.Router
import moxy.InjectViewState
import moxy.MvpPresenter
import toothpick.Toothpick
import javax.inject.Inject

@InjectViewState
class GitHubReposDetailPresenter : MvpPresenter<GitHubReposDetailView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        Toothpick.inject(this, Toothpick.openScope(Scopes.APP_SCOPE))
    }

    fun back(){
        router.backTo(Screens.gitHubReposList())
    }
}