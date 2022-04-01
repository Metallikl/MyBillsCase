package com.luche.mybillscase.presentation.entry_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.luche.mybillscase.R
import com.luche.mybillscase.ResultStatus
import com.luche.mybillscase.databinding.EntryDetailFragmentBinding
import com.luche.mybillscase.model.domain.Category
import com.luche.mybillscase.util.EntryCategoryToIcon
import com.luche.mybillscase.util.toBrazilMoneyFormat
import com.luche.mybillscase.viewmodel.EntryDetailViewModel

class EntryDetailFragment : Fragment() {
    private var _binding: EntryDetailFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: EntryDetailViewModel by viewModel()
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
        iniObservers()
        searchCategory()
    }

    private fun iniObservers() {
        viewModel.resultStatus.observe(viewLifecycleOwner){ resultStatus->
            when(resultStatus){
                is ResultStatus.Success->{
                    handleSuccess(resultStatus.data)
                }
                is ResultStatus.Error->{
                    handleError()
                }
                is ResultStatus.Loading -> {
                    handleStatusLoading()
                }

            }
        }
    }

    private fun handleSuccess(data: Category) {
        binding.tvCategoryDesc.text = data.description
        handleShimmerVisibility()
        binding.clInfos.isVisible = true
    }

    private fun handleError() {
        Snackbar.make(
            binding.root,
            getString(R.string.entries_list_erro_on_call_api),
            BaseTransientBottomBar.LENGTH_INDEFINITE
        )
        .setAction(getString(R.string.entries_list_reload_lbl)){
            viewModel.tryAgain(args.selectedEntry.category)
        }.show()
    }

    private fun handleStatusLoading() {
        with(binding){
            handleShimmerVisibility(true)
            clInfos.isVisible = false
        }
    }

    private fun handleShimmerVisibility(visibility: Boolean = false){
        binding.entryDetailShimmerInclude.shimmerEntryDetail.apply {
            isVisible = visibility
            if(visibility){
                startShimmer()
            }else stopShimmer()
        }
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


    private fun searchCategory() {
        viewModel.getCategory(args.selectedEntry.category)
    }

}