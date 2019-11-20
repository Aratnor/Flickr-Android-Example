package com.lambadam.domain.model.photoModels

import com.google.gson.annotations.SerializedName
import java.util.*

data class Photos(
    @SerializedName("page")
    val page: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("perpage")
    val perpage: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("photo")
    val photo: ArrayList<Photo>
)