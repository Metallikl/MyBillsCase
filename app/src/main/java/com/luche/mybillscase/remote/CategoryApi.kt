package com.luche.mybillscase.remote

import com.luche.mybillscase.model.network.CategoryResponse
import retrofit2.http.GET

interface CategoryApi {

    @GET("categorias")
    fun getCategories() :  List<CategoryResponse>
}