package com.klinovvlad.designpatterns.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.klinovvlad.designpatterns.databinding.ExampleItemBinding
import com.klinovvlad.designpatterns.model.ExampleData

class ExampleAdapter : ListAdapter<ExampleData, ExampleAdapter.ExampleHolder>(ExampleUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleHolder {
        return ExampleHolder(
            ExampleItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ExampleHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class ExampleHolder(private val binding: ExampleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ExampleData) {
            binding.textItemName.text = data.name
        }
    }

    class ExampleUtil : DiffUtil.ItemCallback<ExampleData>() {
        override fun areItemsTheSame(oldItem: ExampleData, newItem: ExampleData): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: ExampleData, newItem: ExampleData): Boolean =
            oldItem == newItem

    }

}