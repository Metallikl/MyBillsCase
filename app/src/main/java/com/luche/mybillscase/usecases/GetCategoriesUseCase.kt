package com.luche.mybillscase.usecases

import com.luche.mybillscase.ResultStatus
import com.luche.mybillscase.model.domain.Category
import com.luche.mybillscase.repository.CategoryRepository

interface GetCategoriesUseCase{
    //O "modificador" operator, pode ser usado com invoke para que a fun seja chamada diretamente
    //na instancia do obj, assim, não é necessario chamar class().invoke()
    suspend operator fun invoke() : ResultStatus<List<Category>>
}

class GetCategoriesUseCaseImpl(
    private val repository: CategoryRepository
) : GetCategoriesUseCase{
    override suspend fun invoke(): ResultStatus<List<Category>> {
        return when(val result = repository.getCategories()){
                    is ResultStatus.Success ->{
                        ResultStatus.Success(
                            result.data.sortedBy {
                                it.id
                            }
                        )
                    }
                    else -> result
        }
    }
}

