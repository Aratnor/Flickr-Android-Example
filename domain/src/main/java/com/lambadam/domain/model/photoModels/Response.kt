package com.lambadam.domain.model.photoModels

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("photos")
    val photos: Photos,
    @SerializedName("stat")
    val stat: String
)