package com.luche.mybillscase.remote

import com.luche.mybillscase.model.network.EntryResponse

class RetrofitEntryRemoteDataSourceImpl(
    private val entryApi: EntryApi
): EntryRemoteDataSource<List<EntryResponse>> {
    override suspend fun fetchEntries(): List<EntryResponse> {
        return entryApi.getEntries()
    }
}