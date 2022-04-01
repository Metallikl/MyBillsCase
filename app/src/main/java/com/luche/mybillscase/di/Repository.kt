package com.luche.mybillscase.di

import com.luche.mybillscase.ResultStatus
import com.luche.mybillscase.model.domain.Entry
import com.luche.mybillscase.model.network.EntryResponse
import com.luche.mybillscase.remote.CategoryRemoteDataSource
import com.luche.mybillscase.remote.EntryRemoteDataSource
import com.luche.mybillscase.remote.RetrofitCategoryRemoteDataSource
import com.luche.mybillscase.remote.RetrofitEntryRemoteDataSourceImpl
import com.luche.mybillscase.repository.CategoryRepository
import com.luche.mybillscase.repository.CategoryRepositoryImpl
import com.luche.mybillscase.repository.EntryRepository
import com.luche.mybillscase.repository.EntryRepositoryImpl
import org.koin.dsl.module

object Repository {
    val repository = module {
        /**
         * Para definir a dependencia de uma interface, apos definirmos o tipo , se single, factory
         * etc, colocamos entre <> a interface e dentro das {} qual implementação
         * concreta que desejamos retornar
         */
        //Entry
        single<EntryRemoteDataSource<List<EntryResponse>>>{
            RetrofitEntryRemoteDataSourceImpl(get())
        }

        single<EntryRepository<ResultStatus<List<Entry>>>> {
            EntryRepositoryImpl(get())
        }

        //Category
        single<CategoryRemoteDataSource>{
            //Cria implementação do data source de categoria, recebendo como param
            //dependencia da api de category gerada.
            RetrofitCategoryRemoteDataSource(get())
        }

        single<CategoryRepository> {
            CategoryRepositoryImpl(get())
        }

    }
}