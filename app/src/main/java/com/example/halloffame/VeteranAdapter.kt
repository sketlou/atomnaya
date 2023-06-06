package com.example.halloffame

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.halloffame.databinding.RvItemBinding

class VeteranListAdapter(
    private val onItemClicked: (Veteran) -> Unit
) : ListAdapter<Veteran, VeteranListAdapter.VeteranViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VeteranViewHolder(
        RvItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: VeteranViewHolder, position: Int) =
        holder.bind(getItem(position), onItemClicked)

    class VeteranViewHolder(private val binding: RvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(Veteran: Veteran, onItemClicked: (Veteran) -> Unit) {
            binding.text.text = Veteran.name
            binding.image.setImageResource(Veteran.image)
            binding.root.setOnClickListener {
                onItemClicked(Veteran)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Veteran>() {
            override fun areItemsTheSame(oldItem: Veteran, newItem: Veteran): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Veteran, newItem: Veteran): Boolean =
                oldItem == newItem
        }
    }
}