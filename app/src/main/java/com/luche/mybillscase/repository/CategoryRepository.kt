package com.luche.mybillscase.repository

import androidx.lifecycle.LiveData
import com.luche.mybillscase.ResultStatus
import com.luche.mybillscase.model.domain.Category

interface CategoryRepository{
  suspend fun getCategories(): ResultStatus<List<Category>>
  suspend fun getCategory(categoryId: Int): ResultStatus<Category>
}