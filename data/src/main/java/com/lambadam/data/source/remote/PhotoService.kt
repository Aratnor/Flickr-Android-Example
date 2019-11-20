package com.lambadam.data.source.remote

import com.lambadam.domain.model.photoModels.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoService {
    @GET("rest/")
    fun getRecentPhotos(@Query("method")method: String,
                        @Query("api_key")api_key: String,
                        @Query("per_page")per_page: String,
                        @Query("page")page: String,
                        @Query("format")format: String,
                        @Query("nojsoncallback")nojsoncallback: String): Call<Response>
}