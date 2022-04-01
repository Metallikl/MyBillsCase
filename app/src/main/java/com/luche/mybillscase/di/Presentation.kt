package com.luche.mybillscase.di

import com.luche.mybillscase.viewmodel.EntriesListViewModel
import com.luche.mybillscase.viewmodel.EntryDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Presentation {

    val presentation = module {

        viewModel {
            EntriesListViewModel(get())
        }

        viewModel {
            EntryDetailViewModel(get())
        }
    }
}