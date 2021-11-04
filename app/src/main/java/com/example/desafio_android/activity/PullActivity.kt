package com.example.desafio_android.activity


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio_android.adapter.PullAdapter
import com.example.desafio_android.databinding.ActivityPullBinding
import com.example.desafio_android.viewModel.PullViewModel

class PullActivity :
    AppCompatActivity(),
    PullAdapter.RecyclerClickListener
{
    private lateinit var bindingPull: ActivityPullBinding
    private var owner = ""
    private var repositorio = ""
    private lateinit var viewModelPull: PullViewModel
    private val adapterPull = PullAdapter(ArrayList(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelPull = ViewModelProvider(this).get()
        initReciclerView()
    }

    private fun initReciclerView() {
        bindingPull = ActivityPullBinding.inflate(layoutInflater)
        setContentView(bindingPull.root)
        bindingPull.pullRecycler.adapter = adapterPull
        bindingPull.pullRecycler.layoutManager = LinearLayoutManager(this)
        owner = intent.getStringExtra("owner").toString()
        repositorio = intent.getStringExtra("repositorie").toString()
        bindingPull.pullRecycler.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
        getPull()
    }

    private fun getPull() {
        handleSuccesGetPullRepositories()
        handleErrorGetPullRepositories()
    }

    private fun handleErrorGetPullRepositories() {
        viewModelPull.hasError.observe(this, Observer {
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
        })
    }

    private fun handleSuccesGetPullRepositories() {
        viewModelPull.allPullRequest.observe(this, Observer {
            adapterPull.listPull.addAll(it)
            adapterPull.notifyDataSetChanged()
        })
        viewModelPull.getPullRequests(owner, repositorio)
    }

    override fun onRecyclerClickListener(position: Int) {
        Log.d("TEST", "onRecyclerClickListener")
        val url = adapterPull.listPull[position].url
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).also{
            startActivity((it))
        }
    }
}