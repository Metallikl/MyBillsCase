package com.luche.mybillscase.presentation.entry_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.luche.mybillscase.databinding.EntryItemBinding
import com.luche.mybillscase.model.domain.Entry
import com.luche.mybillscase.util.EntryCategoryToIcon
import com.luche.mybillscase.util.toBrazilMoneyFormat
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class EntryItemVH(
    private val binding: EntryItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(entry: Entry){
        with(binding){
            ivEntryIcon.apply {
                setImageDrawable(
                    ContextCompat.getDrawable
                        (context,
                        EntryCategoryToIcon().getEntryCategoryIcon(entry.category)
                    )
                )
            }
            tvEntryValue.text = entry.value.toBrazilMoneyFormat()
            tvEntryDesc.text = entry.origin
            tvEntryDate.text = getMonthDesc(entry.entryMonth)
        }
    }

    private fun getMonthDesc(entryMonth: Int): String {
        val calendar = Calendar.getInstance().apply {
            set(Calendar.MONTH, entryMonth)
        }
        return try {
           SimpleDateFormat("MMMM").format(calendar.time)
        }catch (e: Exception){
            entryMonth.toString()
        }
    }

    companion object{
        fun create(parent: ViewGroup) =
            EntryItemVH(
                EntryItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
    }
}
