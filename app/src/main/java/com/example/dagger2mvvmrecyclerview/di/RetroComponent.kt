package com.example.dagger2mvvmrecyclerview.di

import com.example.dagger2mvvmrecyclerview.RetroModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetroModule::class])
interface RetroComponent {

    fun inject()
}