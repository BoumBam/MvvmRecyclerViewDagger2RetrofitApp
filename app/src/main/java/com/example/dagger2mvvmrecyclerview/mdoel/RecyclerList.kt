package com.example.dagger2mvvmrecyclerview.mdoel

data class RecyclerList(val item: List<RecyclerData>)
data class RecyclerData(val name: String?, val description: String?, val owner: Owner)
data class Owner(val avatar_url: String?)
