package com.lambadam.data.listPhotos

import com.lambadam.data.source.remote.PhotoDatabase
import com.lambadam.domain.listphotos.ListPhotosRepository
import com.lambadam.domain.model.Resource
import com.lambadam.domain.model.photoModels.Response

class ImpListPhotosRepository constructor(
    val photoDatabase: PhotoDatabase
): ListPhotosRepository {


    override suspend fun listPhotosRepository(): Resource<Response> {
        return photoDatabase.getAllPhotos()
    }

}