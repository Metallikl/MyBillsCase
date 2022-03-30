package com.luche.mybillscase.repository

import androidx.lifecycle.LiveData
import com.luche.mybillscase.model.domain.Category

interface CategoryRepository {
    fun getCategories(): LiveData<List<Category>>
}