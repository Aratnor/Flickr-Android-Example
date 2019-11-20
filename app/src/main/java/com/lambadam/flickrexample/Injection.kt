package com.lambadam.flickrexample

import com.lambadam.data.listPhotos.ImpListPhotosRepository
import com.lambadam.data.source.remote.PhotoDatabase
import com.lambadam.domain.listphotos.ListPhotosProvider
import com.lambadam.domain.listphotos.ListPhotosRepository
import com.lambadam.domain.listphotos.ResetPhotoPageProvider

object Injection {
    fun providePhotosProvider(): ListPhotosProvider {
        val photoDatabase = PhotoDatabase.getInstance()
        val repository = ImpListPhotosRepository.getInstance(photoDatabase)
        return ListPhotosProvider(repository)
    }
    fun provideResetPhotosProvider(): ResetPhotoPageProvider {
        val photoDatabase = PhotoDatabase.getInstance()
        val repository = ImpListPhotosRepository.getInstance(photoDatabase)
        return ResetPhotoPageProvider(repository)
    }
}