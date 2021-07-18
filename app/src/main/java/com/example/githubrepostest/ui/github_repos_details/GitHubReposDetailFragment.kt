package com.example.githubrepostest.ui.github_repos_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import com.example.githubrepostest.databinding.FragmentGitHubReposDetailBinding
import com.example.githubrepostest.domain.entities.GitHubRepo
import com.example.githubrepostest.ui.util.loadImage
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class GitHubReposDetailFragment() : MvpAppCompatFragment(), GitHubReposDetailView {

    @InjectPresenter
    lateinit var presenter: GitHubReposDetailPresenter

    private lateinit var binding: FragmentGitHubReposDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentGitHubReposDetailBinding.inflate(inflater, container, false)

        binding.gitHubRepoDetailBackButton.setOnClickListener{presenter.back()}

        val gitHubRepo = requireArguments().getParcelable<GitHubRepo>("git_hub_repo") as GitHubRepo

        showGitHubRepoDetails(gitHubRepo)

        return binding.root
    }

    override fun showGitHubRepoDetails(gitHubRepo: GitHubRepo) {

        binding.gitHubRepoDetailName.text = gitHubRepo.name
        binding.gitHubRepoDetailAuthorLogin.text = gitHubRepo.owner.login
        binding.gitHubRepoDetailAuthorAvatar.loadImage(gitHubRepo.owner.avatarUrl.toUri())
        binding.gitHubRepoDetailCreatedAt.text = gitHubRepo.createdAt.replace(Regex("[T,Z]")," ")
        binding.gitHubRepoDetailStarsCount.text = gitHubRepo.starsCount.toString()
        binding.gitHubRepoDetailForksCount.text = gitHubRepo.forksCount.toString()
        binding.gitHubRepoDetailDescription.text = gitHubRepo.description
    }

    companion object {

        fun newInstance(gitHubRepo: GitHubRepo): GitHubReposDetailFragment {

            val gitHubReposDetailFragment = GitHubReposDetailFragment()

            val bundle = Bundle()
            bundle.putParcelable("git_hub_repo", gitHubRepo)
            gitHubReposDetailFragment.arguments = bundle

            return gitHubReposDetailFragment
        }
    }
}