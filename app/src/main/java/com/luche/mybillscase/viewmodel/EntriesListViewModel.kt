package com.luche.mybillscase.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luche.mybillscase.ResultStatus
import com.luche.mybillscase.model.domain.Entry
import com.luche.mybillscase.usecases.GetEntriesListUseCase
import kotlinx.coroutines.launch

class EntriesListViewModel(
    private val getEntriesListUseCaseImpl: GetEntriesListUseCase
) : ViewModel() {
    private var _resultStatusLiveData = MutableLiveData<ResultStatus<List<Entry>>>().apply {
        value = ResultStatus.Loading
    }
    val resultStatusLiveData get() = _resultStatusLiveData as LiveData<ResultStatus<List<Entry>>>
    //
    fun getEntriesList(){
        viewModelScope.launch{
            _resultStatusLiveData.value = getEntriesListUseCaseImpl.invoke()
        }
    }

    fun tryAgain() {
        _resultStatusLiveData.value = ResultStatus.Loading
        getEntriesList()
    }
}