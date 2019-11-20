package com.lambadam.domain.listphotos

import com.lambadam.domain.model.Resource
import com.lambadam.domain.model.photoModels.Response
import com.lambadam.domain.usecase.UseCaseWithParams

class ListPhotosProvider constructor(private val listPhotosRepository: ListPhotosRepository)
    : UseCaseWithParams<ListPhotosProvider.Params, Resource<Response>>() {
    override suspend fun buildUseCase(params: Params): Resource<Response> {
        return listPhotosRepository.listPhotosRepository(params)
    }

    data class Params(
        val url: String
    )
}