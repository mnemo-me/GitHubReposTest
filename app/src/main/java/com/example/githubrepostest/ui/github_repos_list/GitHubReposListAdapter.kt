package com.example.githubrepostest.ui.github_repos_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepostest.R
import com.example.githubrepostest.databinding.GitHubRepoBinding
import com.example.githubrepostest.domain.entities.GitHubRepo
import com.example.githubrepostest.ui.util.loadImage

class GitHubReposListAdapter : PagingDataAdapter<GitHubRepo, GitHubReposListAdapter.ViewHolder>(GitHubRepoDiffCallback()) {

    lateinit var clickListener: ClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it, clickListener)
        }
    }

    class ViewHolder(val binding: GitHubRepoBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(gitHubRepo: GitHubRepo, clickListener: ClickListener){
            binding.gitGubRepoImage.loadImage(R.drawable.git_repository)
            binding.gitHubRepoAuthor.text = gitHubRepo.owner.login
            binding.gitHubRepoName.text = gitHubRepo.name
            binding.root.setOnClickListener {view -> clickListener.onClick(gitHubRepo) }
        }

        companion object{
            fun from(parent: ViewGroup) : ViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val binding = GitHubRepoBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class GitHubRepoDiffCallback : DiffUtil.ItemCallback<GitHubRepo>(){
        override fun areItemsTheSame(oldItem: GitHubRepo, newItem: GitHubRepo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GitHubRepo, newItem: GitHubRepo): Boolean {
            return oldItem == newItem
        }
    }

    class ClickListener(val clickListener: (gitHubRepo : GitHubRepo) -> Unit){
        fun onClick(gitHubRepo: GitHubRepo) = clickListener(gitHubRepo)
    }

}