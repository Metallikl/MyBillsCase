package com.luche.mybillscase.presentation.entry_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.luche.mybillscase.databinding.EntryDetailFragmentBinding
import com.luche.mybillscase.util.EntryCategoryToIcon
import com.luche.mybillscase.util.toBrazilMoneyFormat
import com.luche.mybillscase.viewmodel.EntryDetailViewModel

class EntryDetailFragment : Fragment() {
    private var _binding: EntryDetailFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: EntryDetailViewModel
    private val args: EntryDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return EntryDetailFragmentBinding.inflate(
            layoutInflater,container,false
        ).apply {
            _binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUiInfo()
    }

    private fun setUiInfo() {
        with(binding){
            ivIconCategory.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    EntryCategoryToIcon().getEntryCategoryIcon(args.selectedEntry.category)
                )
            )
            //
            tvOrigin.text = args.selectedEntry.origin
            tvValue.text = args.selectedEntry.value.toBrazilMoneyFormat()
        }
    }
}