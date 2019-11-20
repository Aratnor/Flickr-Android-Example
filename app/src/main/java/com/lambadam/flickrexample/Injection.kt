package com.lambadam.flickrexample

import com.lambadam.data.listPhotos.ImpListPhotosRepository
import com.lambadam.data.source.remote.PhotoDatabase
import com.lambadam.domain.listphotos.ListPhotosProvider
import com.lambadam.domain.listphotos.ListPhotosRepository

object Injection {
    fun providePhotosProvider(): ListPhotosProvider {
        val photoDatabase = PhotoDatabase.getInstance()
        val repository = ImpListPhotosRepository(photoDatabase)
        return ListPhotosProvider(repository)
    }
}