package com.luche.mybillscase.di

import com.luche.mybillscase.remote.EntryApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://desafio-it-server.herokuapp.com/"

object Network {
    val network = module {

        single {
            Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(EntryApi::class.java)

        }
    }
}