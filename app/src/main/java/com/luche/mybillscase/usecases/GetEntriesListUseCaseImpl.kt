package com.luche.mybillscase.usecases

import com.luche.mybillscase.ResultStatus
import com.luche.mybillscase.model.domain.Entry
import com.luche.mybillscase.repository.EntryRepository

class GetEntriesListUseCaseImpl(
    private val entryRepository: EntryRepository<ResultStatus<List<Entry>>>
) :GetEntriesListUseCase {
    override suspend fun invoke(): ResultStatus<List<Entry>> {
        return entryRepository.getEntries()
    }
}

interface GetEntriesListUseCase{
    suspend operator fun invoke() : ResultStatus<List<Entry>>
}