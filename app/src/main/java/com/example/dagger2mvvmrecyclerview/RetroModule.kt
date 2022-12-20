package com.example.dagger2mvvmrecyclerview

import com.example.dagger2mvvmrecyclerview.di.RetroServiceInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class RetroModule {

    val baseUrl = "https://api.github.com/search/"

    @Singleton
    @Provides
    fun getRetroServiceInterface(retrofit: Retrofit): RetroServiceInterface {
        return  retrofit.create(RetroServiceInterface::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}