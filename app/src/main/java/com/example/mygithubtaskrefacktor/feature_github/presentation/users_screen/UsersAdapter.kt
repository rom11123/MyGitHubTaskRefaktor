package com.example.mygithubtaskrefacktor.feature_github.presentation.users_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mygithubtaskrefacktor.databinding.ItemUsersBinding
import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.AllUsersEntity

class UsersAdapter: ListAdapter<AllUsersEntity, UsersAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<AllUsersEntity>() {
        override fun areItemsTheSame(oldItem: AllUsersEntity, newItem: AllUsersEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: AllUsersEntity, newItem: AllUsersEntity): Boolean {
            return oldItem.id == newItem.id
        }
    }

    inner class ViewHolder(private var binding: ItemUsersBinding):
        RecyclerView.ViewHolder(binding.root){


        fun bind(users: AllUsersEntity){
            binding.usersLogin.text = users.login
            Glide.with(binding.usersImage.context)
                .load(users.avatarUrl)
                .into(binding.usersImage)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val users = getItem(position)
        holder.bind(users)
        holder.itemView.setOnClickListener {  onItemClickListener?.let { it(users) }
       }
    }

    private var onItemClickListener: ((AllUsersEntity) -> Unit)? = null

    fun setOnItemClickListener(listener: (AllUsersEntity) -> Unit) {
        onItemClickListener = listener
    }
}