package com.luche.mybillscase.presentation.entry_list

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.luche.mybillscase.model.domain.Entry

class EntriesAdapter(
    private val onEntryClick: (entry: Entry) -> Unit
) : ListAdapter<Entry, EntryItemVH>(diffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = EntryItemVH.create(parent,onEntryClick)

    override fun onBindViewHolder(holder: EntryItemVH, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object{
        private val diffCallback =  object : DiffUtil.ItemCallback<Entry>() {
            override fun areItemsTheSame(oldItem: Entry, newItem: Entry): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Entry, newItem: Entry): Boolean {
                return oldItem == newItem
            }
        }
    }

}