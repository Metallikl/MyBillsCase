package com.luche.mybillscase.remote

interface EntryRemoteDataSource<T> {
    suspend fun fetchEntries() : T
}