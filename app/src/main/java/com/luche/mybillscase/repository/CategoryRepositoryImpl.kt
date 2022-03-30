package com.luche.mybillscase.repository

import com.luche.mybillscase.ResultStatus
import com.luche.mybillscase.model.domain.Category
import com.luche.mybillscase.model.network.toCategoryModel
import com.luche.mybillscase.remote.CategoryRemoteDataSource

class CategoryRepositoryImpl(
    private val remoteDataSource: CategoryRemoteDataSource
): CategoryRepository {
    override suspend fun getCategories(): ResultStatus<List<Category>> {
        return try{
            val categories = remoteDataSource.fetchCategories().map {
                it.toCategoryModel()
            }
            ResultStatus.Success(categories)
        }catch (e: Exception){
            ResultStatus.Error(e)
        }
    }

    override suspend fun getCategory(categoryId: Int): ResultStatus<Category> {
        return try {
            when (val result = getCategories()) {
                is ResultStatus.Success -> {
                    val category = result.data.find {
                        it.id == categoryId
                    }
                    ResultStatus.Success(category!!)
                }
                is ResultStatus.Error -> {
                    ResultStatus.Error(result.throwable)
                }
                else -> ResultStatus.Loading
            }
        }catch (e:Exception){
            ResultStatus.Error(e)
        }
    }
}