package com.example.githubrepostest.ui.github_repos_list

import androidx.paging.rxjava3.cachedIn
import com.example.githubrepostest.di.Scopes
import com.example.githubrepostest.domain.entities.GitHubRepo
import com.example.githubrepostest.domain.usecases.GetGitHubReposList
import com.example.githubrepostest.ui.navigation.Screens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.presenterScope
import toothpick.Toothpick
import javax.inject.Inject

@InjectViewState
class GitHubReposListPresenter : MvpPresenter<GitHubReposListView>() {

    @Inject
    lateinit var getGitHubReposList: GetGitHubReposList

    @Inject
    lateinit var router: Router

    private var keyword: String = ""

    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        Toothpick.inject(this, Toothpick.openScope(Scopes.APP_SCOPE))
    }

    fun searchGitHubReposByKeyword(keyword: String) {
        this.keyword = keyword
        updateList()
    }

    fun showGitHubRepoDetails(gitHubRepo: GitHubRepo){
        router.navigateTo(Screens.gitHubReposDetail(gitHubRepo))
    }

    fun updateList(){
        disposable.add(getGitHubReposList(keyword)
            .cachedIn(presenterScope)
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe { gitHubReposList ->
                viewState.showGitHubReposList(gitHubReposList)
                viewState.stopRefreshingIndicator()
            }
        )

    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}