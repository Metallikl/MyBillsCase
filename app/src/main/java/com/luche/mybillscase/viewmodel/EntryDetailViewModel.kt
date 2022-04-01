package com.luche.mybillscase.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luche.mybillscase.ResultStatus
import com.luche.mybillscase.model.domain.Category
import com.luche.mybillscase.usecases.GetCategoryByIdUseCase
import kotlinx.coroutines.launch

class EntryDetailViewModel(
    private val categoryByIdUseCase: GetCategoryByIdUseCase
) : ViewModel() {

    private val _resultStatus = MutableLiveData<ResultStatus<Category>>().apply {
        value = ResultStatus.Loading
    }

    val resultStatus = _resultStatus as LiveData<ResultStatus<Category>>

    fun getCategory(categoryId: Int){
        viewModelScope.launch {
            _resultStatus.value = categoryByIdUseCase(categoryId)
        }
    }

    fun tryAgain(categoryId: Int) {
        _resultStatus.value = ResultStatus.Loading
        getCategory(categoryId)
    }
}