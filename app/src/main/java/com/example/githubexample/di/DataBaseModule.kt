package com.example.githubexample.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.githubexample.R
import com.example.githubexample.db.DataBase
import com.example.githubexample.db.GithubDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): DataBase {
        return Room
            .databaseBuilder(
                context,
                DataBase::class.java,
                context.getString(R.string.database)
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideAvengersDao(appDatabase: DataBase): GithubDao {
        return appDatabase.GitHubDao()
    }


}