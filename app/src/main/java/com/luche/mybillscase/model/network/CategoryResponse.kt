package com.luche.mybillscase.model.network

import com.luche.mybillscase.model.domain.Category

data class CategoryResponse(
    val id: Int,
    val nome: String
)

fun CategoryResponse.toCategoryModel() : Category {
    return Category(
        this.id,
        this.nome
    )
}

