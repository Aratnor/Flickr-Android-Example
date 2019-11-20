package com.lambadam.data.source.remote

import android.util.Log
import com.lambadam.domain.model.Resource
import com.lambadam.domain.model.photoModels.Response

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.await

class PhotoDatabase private constructor(
    retrofitClient: Retrofit) {

    private val mRetroFitClient = retrofitClient

    private val method = "flickr.photos.getRecent"
    private val api_key = "4bec4c1a302d3b59a228a9413429ae85"
    private val per_page = 20
    private var page = 0
    private val format = "json"
    private val nojsoncallback = "1"

    companion object {
        var INSTANCE: PhotoDatabase? = null

        fun getInstance(): PhotoDatabase {
            if(INSTANCE != null) return INSTANCE!!
            synchronized(this) {
                val rfClient = RetrofitClient.getClient()
                INSTANCE = PhotoDatabase(rfClient)
                return INSTANCE!!
            }
        }
    }


    suspend fun getAllPhotos(): Resource<Response> {
        page += 1
        val service = mRetroFitClient.create(PhotoService::class.java)
        val call = service.getRecentPhotos(
            method,
            api_key,
            per_page.toString(),
            page.toString(),
            format,
            nojsoncallback
        )
        return getResponse(call)
    }

    private suspend fun getResponse(call: Call<Response>): Resource<Response> {
        val response = call.await()
        Log.i("Response",response.toString())
        return Resource.success(response)
    }
    fun resetPage() {
        page = 0
    }
}