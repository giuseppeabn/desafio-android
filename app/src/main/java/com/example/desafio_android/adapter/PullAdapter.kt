package com.example.desafio_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafio_android.databinding.ItemPullBinding
import com.example.desafio_android.model.PullRequest

class PullAdapter(
    val listPull: MutableList<PullRequest>,
    private val recyclerRepositoryClickListener: RecyclerClickListener
) : RecyclerView.Adapter<PullAdapter.ViewHolder>() {


    override fun getItemCount(): Int {
        return listPull.size
    }

    override fun onBindViewHolder(holder: PullAdapter.ViewHolder, position: Int) {
        holder.bindingPull(listPull[position])
        holder.itemPull.cardPull.setOnClickListener {
            recyclerRepositoryClickListener.onRecyclerClickListener(position)
        }

    }

    class ViewHolder(val itemPull: ItemPullBinding) : RecyclerView.ViewHolder(itemPull.root) {

        fun bindingPull(pullRequest: PullRequest) {
            with(itemPull){
                titlePull.text = pullRequest.title
                descriptionPull.text = pullRequest.body
                usernamePull.text = pullRequest.owner.login
                Glide.with(avatarUser)
                    .load(pullRequest.owner.avatar)
                    .circleCrop()
                    .into(avatarUser)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            PullAdapter.ViewHolder {
        return ViewHolder(
            ItemPullBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    interface RecyclerClickListener {
        fun onRecyclerClickListener(position: Int)
    }
}