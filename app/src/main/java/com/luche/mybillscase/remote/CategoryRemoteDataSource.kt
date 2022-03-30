package com.luche.mybillscase.remote

import com.luche.mybillscase.model.network.CategoryResponse

interface CategoryRemoteDataSource {
   suspend fun fetchCategories() : List<CategoryResponse>
}