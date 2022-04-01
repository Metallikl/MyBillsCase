package com.luche.mybillscase.di

import com.luche.mybillscase.remote.CategoryApi
import com.luche.mybillscase.remote.EntryApi
import get
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.sin

private const val BASE_URL = "https://desafio-it-server.herokuapp.com/"

object Network {
    val network = module {

        //Retrofit
        single {
            Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        //EntryApi
        single {
            (get() as Retrofit).create(EntryApi::class.java)

        }
        //CategoryApi
        single {
            (get() as Retrofit).create(CategoryApi::class.java)
        }
    }
}