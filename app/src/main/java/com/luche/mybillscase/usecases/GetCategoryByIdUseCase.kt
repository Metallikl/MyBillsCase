package com.luche.mybillscase.usecases

import com.luche.mybillscase.ResultStatus
import com.luche.mybillscase.model.domain.Category
import com.luche.mybillscase.repository.CategoryRepository

interface GetCategoryByIdUseCase {
    suspend operator fun invoke(categoryId: Int) : ResultStatus<Category>
}

class GetCategoryByIdUseCaseImpl(
    private val repository: CategoryRepository
) : GetCategoryByIdUseCase {
    override suspend fun invoke(categoryId: Int): ResultStatus<Category> {
        return repository.getCategory(categoryId)
    }
}