package com.example.githubexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubexample.R
import com.example.githubexample.adapter.FooterAdapter
import com.example.githubexample.adapter.GitHubAdapter
import com.example.githubexample.databinding.ActivityGitHubBinding
import com.example.githubexample.view.base.BaseActivity
import com.example.githubexample.viewmodel.GitHubViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import timber.log.Timber


@AndroidEntryPoint
class GitHubActivity : BaseActivity() {

    private val binding by binding<ActivityGitHubBinding>(R.layout.activity_git_hub)

    private val gitHubviewModel: GitHubViewModel by viewModels()
    private val gitHubAdapter by lazy {
        GitHubAdapter()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        repeatOnStarted {
//            gitHubviewModel.gitHubList.collectLatest { pagingData ->
//            }
//        }


        repeatOnStarted {
            gitHubviewModel.pageValue.combine(gitHubviewModel.searchValue) { page, serchvalue -> }
                .collect {
                    repeatOnStarted {
                        Timber.d("colletData")
                        gitHubviewModel.fetchGitHubList().collectLatest {
                            gitHubAdapter.submitData(it)
                        }
                    }
                }
        }

        // Adapter Setting
        with(binding) {
            viewmodel = gitHubviewModel
            listGithub.layoutManager = LinearLayoutManager(this@GitHubActivity)
            listGithub.adapter = gitHubAdapter.withLoadStateFooter(FooterAdapter { gitHubAdapter.retry() })
        }

    }
}


