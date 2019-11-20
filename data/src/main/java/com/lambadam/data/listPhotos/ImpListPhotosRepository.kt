package com.lambadam.data.listPhotos

import com.lambadam.data.source.remote.PhotoDatabase
import com.lambadam.domain.listphotos.ListPhotosRepository
import com.lambadam.domain.model.Resource
import com.lambadam.domain.model.photoModels.Response

class ImpListPhotosRepository constructor(
    private val photoDatabase: PhotoDatabase
): ListPhotosRepository {
    override suspend fun resetPhotoPage() {
        photoDatabase.resetPage()
    }


    override suspend fun listPhotosRepository(): Resource<Response> {
        return photoDatabase.getAllPhotos()
    }

    companion object {
        var INSTANCE: ImpListPhotosRepository? = null

        fun getInstance(photoDatabase: PhotoDatabase): ImpListPhotosRepository {
            if(INSTANCE != null) return INSTANCE!!
            synchronized(this) {
                INSTANCE = ImpListPhotosRepository(photoDatabase)
                return INSTANCE!!
            }
        }
    }

}