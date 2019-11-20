package com.lambadam.domain.listphotos

import com.lambadam.domain.model.Resource
import com.lambadam.domain.model.photoModels.Response
import com.lambadam.domain.usecase.UseCase
import com.lambadam.domain.usecase.UseCaseWithParams

class ListPhotosProvider constructor(private val listPhotosRepository: ListPhotosRepository)
    : UseCase<Resource<Response>>() {
    override suspend fun buildUseCase(): Resource<Response> {
        return listPhotosRepository.listPhotosRepository()
    }

}