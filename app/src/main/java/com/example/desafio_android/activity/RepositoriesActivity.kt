package com.example.desafio_android.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio_android.R
import com.example.desafio_android.adapter.RepositoriesAdapter
import com.example.desafio_android.databinding.ActivityRepositoryBinding

class RepositoriesActivity : AppCompatActivity(), RepositoriesAdapter.RecyclerViewClickListener {
    private val adapterRepositories = RepositoriesAdapter(ArrayList(), this)
    private lateinit var binding: ActivityRepositoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding = ActivityRepositoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.repositoryRecycler.adapter = adapterRepositories
    }

    override fun onRecyclerViewItemClick(position: Int) {
        Log.d("Test", position.toString())
    }
}