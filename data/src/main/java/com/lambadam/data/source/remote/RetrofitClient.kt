package com.lambadam.data.source.remote

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.xml.datatype.DatatypeConstants.SECONDS



class RetrofitClient {

    companion object {
        private val httpClient = OkHttpClient()


        fun getClient(): Retrofit {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            return Retrofit.Builder()
                .baseUrl("https://www.flickr.com/services/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson)).build()
        }
    }
}