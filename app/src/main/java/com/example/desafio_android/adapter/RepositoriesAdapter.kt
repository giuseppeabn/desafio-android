package com.example.desafio_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_android.databinding.ItemRepositoryBinding


class RepositoriesAdapter(
    val repositories: MutableList<Any>, // TODO: change type Any
    private val listener: RecyclerViewClickListener) : RecyclerView.Adapter<RepositoriesAdapter.ViewHolder>() {

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
        private val itemRepositoryBinding: ItemRepositoryBinding
    ) : RecyclerView.ViewHolder(itemRepositoryBinding.root) {
        fun binding() {
            TODO("Not yet implemented")
        }
    }

    // Encargado de actualizar el item de acuerdo a position
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = repositories.size

    interface RecyclerViewClickListener {
        fun onRecyclerViewItemClick(position: Int)
    }
}