package com.lambadam.domain.listphotos

import com.lambadam.domain.model.Resource
import com.lambadam.domain.model.photoModels.Response
import com.lambadam.domain.usecase.UseCase

class ResetPhotoPageProvider constructor(private val listPhotosRepository: ListPhotosRepository)
    : UseCase<Unit>() {
    override suspend fun buildUseCase() {
        listPhotosRepository.resetPhotoPage()
    }

}