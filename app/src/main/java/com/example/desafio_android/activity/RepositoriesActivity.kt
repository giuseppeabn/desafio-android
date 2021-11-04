package com.example.desafio_android.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio_android.R
import com.example.desafio_android.adapter.RepositoriesAdapter
import com.example.desafio_android.databinding.ActivityRepositoryBinding

class RepositoriesActivity : AppCompatActivity(), RepositoriesAdapter.RecyclerViewClickListener {
    var dummyList: ArrayList<Int> = arrayListOf(1,2,3,4,5,6,7,8,9,0,10,11,12,13)
    private val adapterRepositories = RepositoriesAdapter(dummyList, this)
    private lateinit var binding: ActivityRepositoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)
        initRecyclerView()
    }

    private fun initRecyclerView() {

        binding = ActivityRepositoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("Test", "initRecyclerView")
        binding.repositoryRecycler.adapter = adapterRepositories
        binding.repositoryRecycler.layoutManager = LinearLayoutManager(this)

    }

    override fun onRecyclerViewItemClick(position: Int) {
        Log.d("Test", position.toString())
    }
}