package com.luche.mybillscase.remote

interface CategoryRemoteDataSource<T> {
    fun fetchCategories() : T
}