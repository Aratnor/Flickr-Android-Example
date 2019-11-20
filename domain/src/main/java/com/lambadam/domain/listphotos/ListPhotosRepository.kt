package com.lambadam.domain.listphotos

import com.lambadam.domain.model.Resource
import com.lambadam.domain.model.photoModels.Response

interface ListPhotosRepository {
    suspend fun listPhotosRepository(): Resource<Response>

    suspend fun resetPhotoPage()
}