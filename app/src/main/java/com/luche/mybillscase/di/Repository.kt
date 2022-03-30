package com.luche.mybillscase.di

import com.luche.mybillscase.ResultStatus
import com.luche.mybillscase.model.domain.Entry
import com.luche.mybillscase.model.network.EntryResponse
import com.luche.mybillscase.remote.EntryRemoteDataSource
import com.luche.mybillscase.remote.RetrofitEntryRemoteDataSourceImpl
import com.luche.mybillscase.repository.EntryRepository
import com.luche.mybillscase.repository.EntryRepositoryImpl
import org.koin.dsl.module

object Repository {
    val repository = module {
        single<EntryRemoteDataSource<List<EntryResponse>>>{
            RetrofitEntryRemoteDataSourceImpl(get())
        }

        single<EntryRepository<ResultStatus<List<Entry>>>> {
            EntryRepositoryImpl(get())
        }
    }
}