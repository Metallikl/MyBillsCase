package com.luche.mybillscase.di

import com.luche.mybillscase.usecases.GetCategoryByIdUseCase
import com.luche.mybillscase.usecases.GetCategoryByIdUseCaseImpl
import com.luche.mybillscase.usecases.GetEntriesListUseCase
import com.luche.mybillscase.usecases.GetEntriesListUseCaseImpl
import org.koin.dsl.module

object UseCase {
    val useCases = module {
        factory<GetEntriesListUseCase> {
            GetEntriesListUseCaseImpl(entryRepository = get())
        }
        //
        factory<GetCategoryByIdUseCase>{
            GetCategoryByIdUseCaseImpl(repository = get())
        }
    }
}