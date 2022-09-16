package com.example.mygithubtaskrefacktor.feature_github.presentation.repository_screen
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mygithubtaskrefacktor.databinding.ItemRepositoryBinding
import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.RepositoryEntity

class RepoAdapter:
    ListAdapter<RepositoryEntity, RepoAdapter.ViewHolder>(DiffCallback) {


    companion object DiffCallback : DiffUtil.ItemCallback<RepositoryEntity>() {
        override fun areItemsTheSame(oldItem: RepositoryEntity, newItem: RepositoryEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: RepositoryEntity, newItem: RepositoryEntity): Boolean {
            return oldItem.id == newItem.id
        }
    }


    inner class ViewHolder(private var binding: ItemRepositoryBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(repository: RepositoryEntity){
            binding.tvRepoName.text = repository.name
            binding.tvLanguage.text = repository.language
            binding.tvVisibility.text = if (repository.isPrivate) "Private" else "Public"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repository = getItem(position)
        holder.bind(repository)
    }
}