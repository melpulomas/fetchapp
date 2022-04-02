package com.fetchapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.fetchapp.databinding.FetchitemBinding

class FetchItemAdapter : RecyclerView.Adapter<FetchItemAdapter.FetchItemViewHolder>() {
    inner class FetchItemViewHolder(val binding: FetchitemBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<FetchItem>() {
        override fun areContentsTheSame(oldItem: FetchItem, newItem: FetchItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areItemsTheSame(oldItem: FetchItem, newItem: FetchItem): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)
    var fetchitem: List<FetchItem>
        get() = differ.currentList
        set(value) {differ.submitList(value)}

    override fun getItemCount() = fetchitem.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FetchItemViewHolder {
        return FetchItemViewHolder(FetchitemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FetchItemViewHolder, position: Int) {
        holder.binding.apply {
            val item = fetchitem[position]
            tvlistId.text = "List ID: ${item.listId}"
            tvname.text = "name: ${item.name}"

        }
    }
}