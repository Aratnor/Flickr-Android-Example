package com.lambadam.flickrexample

import android.annotation.SuppressLint
import android.app.Application
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lambadam.domain.listphotos.ListPhotosProvider
import com.lambadam.domain.listphotos.ResetPhotoPageProvider
import com.lambadam.flickrexample.listPhotos.ListPhotosViewModel

class ViewModelFactory private constructor(
    private val listPhotosProvider: ListPhotosProvider,
    private val resetPhotoPageProvider: ResetPhotoPageProvider
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(ListPhotosViewModel::class.java) ->
                    ListPhotosViewModel(listPhotosProvider,resetPhotoPageProvider)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T

    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application) =
            INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                INSTANCE ?: ViewModelFactory(
                    Injection.providePhotosProvider(),Injection.provideResetPhotosProvider())
                    .also { INSTANCE = it }
            }


        @VisibleForTesting
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
