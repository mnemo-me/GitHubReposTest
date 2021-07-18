package com.example.githubrepostest.ui.github_repos_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.paging.PagingData
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.githubrepostest.databinding.FragmentGitHubReposListBinding
import com.example.githubrepostest.di.Scopes
import com.example.githubrepostest.domain.entities.GitHubRepo
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import toothpick.Toothpick

class GitHubReposListFragment : MvpAppCompatFragment(), GitHubReposListView {

    @InjectPresenter
    lateinit var presenter : GitHubReposListPresenter

    private lateinit var binding: FragmentGitHubReposListBinding

    private val adapter = GitHubReposListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        Toothpick.inject(this, Toothpick.openScope(Scopes.APP_SCOPE))

        binding = FragmentGitHubReposListBinding.inflate(inflater, container, false)

        binding.gitHubReposListList.addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))

        adapter.clickListener = GitHubReposListAdapter.ClickListener{gitHubRepo ->
            presenter.showGitHubRepoDetails(gitHubRepo)
        }
        binding.gitHubReposListList.adapter = adapter

        binding.gitHubReposListSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                presenter.searchGitHubReposByKeyword(query!!)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return false
            }
        })

        binding.gitHubReposListSwipeRefreshLayout.setOnRefreshListener { presenter.updateList() }

        return binding.root
    }


    override fun showGitHubReposList(gitHubReposListPagingData: PagingData<GitHubRepo>) {
        adapter.submitData(lifecycle, gitHubReposListPagingData)
    }

    override fun stopRefreshingIndicator() {
        binding.gitHubReposListSwipeRefreshLayout.isRefreshing = false
    }
}