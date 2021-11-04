package com.example.desafio_android.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio_android.R
import com.example.desafio_android.adapter.RepositoriesAdapter
import com.example.desafio_android.databinding.ActivityRepositoryBinding
import com.example.desafio_android.viewModel.RepositoriesViewModel

class RepositoriesActivity : AppCompatActivity(), RepositoriesAdapter.RecyclerViewClickListener {
    private val adapterRepositories = RepositoriesAdapter(ArrayList(), this)
    private lateinit var binding: ActivityRepositoryBinding
    private lateinit var viewModel: RepositoriesViewModel
    var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get()
        initRecyclerView()
    }

    private fun initRecyclerView() {

        binding = ActivityRepositoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("Test", "initRecyclerView")
        binding.repositoryRecycler.adapter = adapterRepositories
        binding.repositoryRecycler.layoutManager = LinearLayoutManager(this)
        getRepositoryes()
    }

    override fun onRecyclerViewItemClick(position: Int) {
        Log.d("Test", position.toString())
    }

    fun getRepositoryes() {
        handleSuccesGetRespositoryes()
        handleErrorGetRespositoryes()
    }

    private fun handleErrorGetRespositoryes() {
        viewModel.hasError.observe(this, Observer {
            if(it){
                Toast.makeText(this, "Ha ocurrido un error!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun handleSuccesGetRespositoryes() {
        viewModel.allRepositories.observe(this, Observer {
            for (i in it) {
                if (i !in adapterRepositories.repositories) {
                    adapterRepositories.repositories.addAll(listOf(i))
                    adapterRepositories.notifyDataSetChanged()
                }
            }
        })

        Log.d("Test", page.toString())
        viewModel.getPaginatedRepositories(page)
    }
}