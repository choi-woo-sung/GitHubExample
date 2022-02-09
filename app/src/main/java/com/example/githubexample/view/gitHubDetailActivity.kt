package com.example.githubexample.view

import androidx.activity.viewModels
import com.example.githubexample.R
import com.example.githubexample.databinding.ActivityGitHubBinding
import com.example.githubexample.view.base.BaseActivity
import com.example.githubexample.viewmodel.GitHubViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class gitHubDetailActivity : BaseActivity(){

    private val binding by binding<ActivityGitHubBinding>(R.layout.activity_git_hub)

    private val gitHubviewModel: GitHubViewModel by viewModels()




}