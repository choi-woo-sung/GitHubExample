package com.example.githubexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubexample.R
import com.example.githubexample.databinding.ActivityGitHubBinding
import com.example.githubexample.view.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GitHubActivity : BaseActivity() {

    private val binding by binding<ActivityGitHubBinding>(R.layout.activity_git_hub)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}