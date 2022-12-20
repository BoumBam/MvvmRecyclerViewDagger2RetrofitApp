package com.example.dagger2mvvmrecyclerview

import android.app.Application
import com.example.dagger2mvvmrecyclerview.di.RetroComponent

class MyApplication: Application() {

    private lateinit var retroComponent: RetroComponent

    override fun onCreate() {
        super.onCreate()

        retroComponent = DaggerRetroComponent.builder()
            .retroModule(RetroModule())
            .build()
    }

    fun getRetroComponent(): RetroComponent {
        return retroComponent
    }
}