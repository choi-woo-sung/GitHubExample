package com.example.githubexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.githubexample.databinding.FooterItemBinding

class FooterAdapter(val retry: () -> Unit) : LoadStateAdapter<FooterAdapter.ViewHolder>() {

    inner class ViewHolder(
        val binding: FooterItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.retry.setOnClickListener {
                retry
            }
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, loadState: LoadState) {
        holder.binding.progressBar.isVisible = loadState is LoadState.Loading
        holder.binding.retry.isVisible = loadState is LoadState.Error
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ViewHolder {
        return ViewHolder(
            FooterItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}