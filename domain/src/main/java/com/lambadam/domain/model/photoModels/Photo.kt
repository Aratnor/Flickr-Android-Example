package com.lambadam.domain.model.photoModels

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id")
    val id: String,
    @SerializedName("owner")
    val owner: String,
    @SerializedName("secret")
    val secret: String,
    @SerializedName("server")
    val server: Int,
    @SerializedName("farm")
    val farm: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("isPublic")
    val isPublic: Int,
    @SerializedName("isFriend")
    val isFriend: Int,
    @SerializedName("isFamily")
    val isFamily: Int
)