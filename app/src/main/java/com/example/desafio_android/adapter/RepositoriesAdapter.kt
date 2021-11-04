package com.example.desafio_android.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_android.databinding.ItemRepositoryBinding
import com.example.desafio_android.model.Repository

class RepositoriesAdapter(
    val repositories: MutableList<Repository>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<RepositoriesAdapter.ViewHolder>() {
    // Encargado de crear nuevas vistas cuando es requerido
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
                return ViewHolder(
                    ItemRepositoryBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

    // recibe la vista que debe almacenar
    class ViewHolder(
        val itemRepositoryBinding: ItemRepositoryBinding
    ) : RecyclerView.ViewHolder(itemRepositoryBinding.root) {
        fun binding(item: Repository) {
            with(itemRepositoryBinding) {
                textView.text = item.description
            }
        }
    }

    override fun getItemCount(): Int = repositories.size

    interface RecyclerViewClickListener {
        fun onRecyclerViewItemClick(position: Int)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(repositories[position])
        holder.itemRepositoryBinding.cardRepositorio.setOnClickListener {
            listener.onRecyclerViewItemClick(position)
        }

    }
}