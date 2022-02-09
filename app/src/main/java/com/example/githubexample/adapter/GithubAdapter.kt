package com.example.githubexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.githubexample.databinding.ItemGithhubBinding
import com.example.githubexample.model.GitHubDto

class GithubAdapter: PagingDataAdapter<GitHubDto, RecyclerView.ViewHolder>(COMPARATOR) {

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<GitHubDto>() {
            override fun areItemsTheSame(
                oldItem: GitHubDto,
                newItem: GitHubDto
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: GitHubDto,
                newItem: GitHubDto
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is GithHubListHolder) {
            val gitHubDto = getItem(position)

//            //data에 선언된 variable bind
            holder.binding.githubVariable = gitHubDto
//
//
            //MainActivity에 값을 전달할 ClickEvent
            if (position != RecyclerView.NO_POSITION) {
                holder.itemView.setOnClickListener {
                    gitHubDto?.run {
                        listener?.onItemClick(holder.itemView, this, position)
                    }
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return GithHubListHolder(
            ItemGithhubBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    class GithHubListHolder(
        val binding: ItemGithhubBinding
    ) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickListener {
        fun onItemClick(v: View, gitHubDto: GitHubDto, pos: Int)
    }


    private var listener: OnItemClickListener? = null
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

}