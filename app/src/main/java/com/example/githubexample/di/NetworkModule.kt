package com.example.githubexample.di

import com.example.githubexample.di.Quailfiers.Github
import com.example.githubexample.network.GithubService
import com.example.githubexample.network.HttpRequestIntercepter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpRequestIntercepter())
            .build()
    }

    @Provides
    @Singleton
    @Named(Github)
    fun provideRetrofitForgithub(okHttpClient: OkHttpClient): Retrofit {
        val BASE_URL = "https://api.github.com/"
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideGithubService(@Named(Github) retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }

}