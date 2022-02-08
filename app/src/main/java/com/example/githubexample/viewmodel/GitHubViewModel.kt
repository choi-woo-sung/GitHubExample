

package com.example.githubexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.githubexample.di.ResourceProvider
import com.example.githubexample.model.GitHubDto
import com.example.githubexample.repository.GitHubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class GitHubViewModel @Inject constructor(
    private val gitHubRepository: GitHubRepository,
    private val resourceProvider: ResourceProvider
): ViewModel() {


//    private val _spinnerEntry = MutableStateFlow(resourceProvider.getIntArray(R.array.spinner_array).asList() )
//    var  spinnerEntry = _spinnerEntry.asStateFlow()

    //검색 데이터값
     val _searchValue =  MutableStateFlow("Android")
    val searchValue = _searchValue.asStateFlow()



    val _pageValue =  MutableStateFlow("10")
    val pageValue = _pageValue.asStateFlow()




//    private val _ =  MutableStateFlow("")
//    var searchValue = _searchValue.asStateFlow()

    fun fetchGitHubList(): Flow<PagingData<GitHubDto>>  = gitHubRepository.fetchGitHubList(pageSize = pageValue.value , search = searchValue.value).cachedIn(viewModelScope)


    }

