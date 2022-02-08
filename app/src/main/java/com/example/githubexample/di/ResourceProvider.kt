package com.example.githubexample.di

import android.content.Context
import androidx.annotation.ArrayRes
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class ResourceProvider @Inject constructor( @ApplicationContext private val context: Context){


    fun getString(@StringRes resId : Int) = context.getString(resId)

    fun getIntArray(@ArrayRes resId : Int) = context.resources.getIntArray(resId)
}