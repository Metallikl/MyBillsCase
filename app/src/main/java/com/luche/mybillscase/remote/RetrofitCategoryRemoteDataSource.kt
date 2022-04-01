package com.luche.mybillscase.remote

import com.luche.mybillscase.model.network.CategoryResponse

class RetrofitCategoryRemoteDataSource(
    private val categoryApi: CategoryApi
) : CategoryRemoteDataSource{
    override suspend fun fetchCategories(): List<CategoryResponse> {
        return categoryApi.getCategories()
    }
}