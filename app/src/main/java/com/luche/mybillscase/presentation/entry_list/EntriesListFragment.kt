package com.luche.mybillscase.presentation.entry_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_INDEFINITE
import com.google.android.material.snackbar.Snackbar
import com.luche.mybillscase.ResultStatus
import com.luche.mybillscase.databinding.EntriesListFragmentBinding
import com.luche.mybillscase.model.domain.Entry
import com.luche.mybillscase.viewmodel.EntriesListViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class EntriesListFragment : Fragment() {
    private var _binding: EntriesListFragmentBinding? = null
    private val binding get() = _binding!!
    private val mViewModel: EntriesListViewModel by viewModel()
    private val entriesAdapter: EntriesAdapter by lazy {
        EntriesAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return EntriesListFragmentBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            _binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        initObserver()
        callFun()
    }

    private fun callFun() {
        mViewModel.getEntriesList()
    }

    private fun initRecycler() {
        binding.rvEntries.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = entriesAdapter
        }
    }

    private fun initObserver() {
        mViewModel.resultStatusLiveData.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ResultStatus.Loading ->{
                    handleStatusLoading()
                }
                is ResultStatus.Success ->{
                    handleStatusSuccess(result)
                }
                is ResultStatus.Error->{
                    handleStatusError()
                }
            }
        }

    }

    private fun handleStatusError() {
       Snackbar.make(
           binding.root,
           "Erro ao buscar",
           LENGTH_INDEFINITE
       )
       .setAction("Recarregar"){
           mViewModel.tryAgain()
       }.show()
    }

    private fun handleStatusSuccess(result: ResultStatus.Success<List<Entry>>) {
        binding.rvEntries.isVisible = true
        handleShimmerVisibility()
        entriesAdapter.submitList(result.data)
    }

    private fun handleStatusLoading() {
        with(binding){
            handleShimmerVisibility(true)
            rvEntries.isVisible = false
        }
    }

    private fun handleShimmerVisibility(visibility: Boolean = false){
        binding.includeListShimmer.shimmerEntries.apply {
            isVisible = visibility
            if(visibility){
                startShimmer()
            }else stopShimmer()
        }
    }
}