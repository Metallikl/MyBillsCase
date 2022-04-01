package com.luche.mybillscase.remote

import com.luche.mybillscase.model.network.CategoryResponse
import retrofit2.http.GET

interface CategoryApi {
    @GET("categorias")
    suspend fun getCategories() :  List<CategoryResponse>
}