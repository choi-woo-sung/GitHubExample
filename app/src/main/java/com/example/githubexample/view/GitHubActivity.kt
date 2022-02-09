package com.example.githubexample.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubexample.R
import com.example.githubexample.adapter.FooterAdapter
import com.example.githubexample.adapter.GithubAdapter
import com.example.githubexample.databinding.ActivityGitHubBinding
import com.example.githubexample.model.GitHubDto
import com.example.githubexample.view.base.BaseActivity
import com.example.githubexample.viewmodel.GitHubViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import timber.log.Timber


@AndroidEntryPoint
class GitHubActivity : BaseActivity() {

    private val binding by binding<ActivityGitHubBinding>(R.layout.activity_git_hub)

    private val gitHubviewModel: GitHubViewModel by viewModels()
    private val gitHubAdapter by lazy {
        GithubAdapter()
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

            gitHubAdapter.setOnItemClickListener(object:  GithubAdapter.OnItemClickListener{
                override fun onItemClick(v: View, gitHubDto: GitHubDto, pos: Int) {
                    val intent = Intent(this@GitHubActivity, GitHubDetailActivity::class.java)
                    intent.putExtra("Detail", "${gitHubDto.fullName}")
                    startActivity(intent)
                    finish()
                }


            })
        }

    }
}


