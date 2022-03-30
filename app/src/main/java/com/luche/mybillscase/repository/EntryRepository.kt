package com.luche.mybillscase.repository


interface EntryRepository<T> {
    suspend fun getEntries(): T
}