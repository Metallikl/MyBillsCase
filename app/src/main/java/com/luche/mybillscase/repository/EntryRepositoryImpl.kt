package com.luche.mybillscase.repository

import com.luche.mybillscase.ResultStatus
import com.luche.mybillscase.model.domain.Entry
import com.luche.mybillscase.model.network.EntryResponse
import com.luche.mybillscase.model.network.toDomainEntry
import com.luche.mybillscase.remote.EntryRemoteDataSource
import java.lang.Exception

class EntryRepositoryImpl(
    private val entryRemoteDataSource: EntryRemoteDataSource<List<EntryResponse>>
) : EntryRepository<ResultStatus<List<Entry>>> {
    override suspend fun getEntries(): ResultStatus<List<Entry>> {
        return try{
            val entryList = entryRemoteDataSource.fetchEntries().map {
                it.toDomainEntry()
            }.sortedBy {
                it.entryMonth
            }
            //
            ResultStatus.Success(entryList)
        } catch (e: Exception){
            ResultStatus.Error(e)
        }
    }
}