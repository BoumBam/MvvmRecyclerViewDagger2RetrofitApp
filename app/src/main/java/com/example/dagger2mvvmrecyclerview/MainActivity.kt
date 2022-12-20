package com.example.dagger2mvvmrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger2mvvmrecyclerview.mdoel.RecyclerList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerViewAdapter
    }

    private fun initViewModel() {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.getLiveDataObserver().observe(this,
            object : Observer<RecyclerList> {
                override fun onChanged(t: RecyclerList?) {
                    if(t != null) {
                        recyclerViewAdapter.setUpdatedData(t.item)
                        recyclerViewAdapter.notifyDataSetChanged()
                    } else {
                        Toast.makeText(this@MainActivity, "erro getting data", Toast.LENGTH_LONG).show()
                    }


                }
            })

        mainActivityViewModel.makeApiCall()
    }
}