package com.lambadam.flickrexample.listPhotos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lambadam.domain.listphotos.ListPhotosProvider
import com.lambadam.domain.model.photoModels.Photo
import com.lambadam.domain.model.photoModels.Response
import kotlinx.coroutines.launch

class ListPhotosViewModel(
    private val listPhotoProvider: ListPhotosProvider
)  : ViewModel() {

    val responseState: MutableLiveData<Response> = MutableLiveData()
    val photos: MutableLiveData<List<Photo>> = MutableLiveData()

    fun updateAllPhotos() {
        viewModelScope.launch {
             photos.value = listPhotoProvider.execute().data!!.photos.photo
        }
    }

    fun getResponse(){
        viewModelScope.launch {
            responseState.value = listPhotoProvider.execute().data!!
        }
    }
}