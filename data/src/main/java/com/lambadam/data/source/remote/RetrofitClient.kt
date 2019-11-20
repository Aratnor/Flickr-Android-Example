package com.lambadam.data.source.remote

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {

        fun getClient(): Retrofit {
            val gson = GsonBuilder()
                .setLenient()
                .create()

            return Retrofit.Builder()
                .baseUrl("https://www.flickr.com/services/")
                .addConverterFactory(GsonConverterFactory.create(gson)).build()
        }
    }
}