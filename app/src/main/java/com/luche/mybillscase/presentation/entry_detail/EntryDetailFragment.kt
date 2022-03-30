package com.luche.mybillscase.presentation.entry_detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luche.mybillscase.R
import com.luche.mybillscase.viewmodel.EntryDetailViewModel

class EntryDetailFragment : Fragment() {

    companion object {
        fun newInstance() = EntryDetailFragment()
    }

    private lateinit var viewModel: EntryDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.entry_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EntryDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}