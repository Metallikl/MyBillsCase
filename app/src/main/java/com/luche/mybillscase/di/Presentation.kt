package com.luche.mybillscase.di

import com.luche.mybillscase.viewmodel.EntriesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Presentation {

    val presentation = module {

        viewModel {
            EntriesListViewModel(get())
        }
    }
}