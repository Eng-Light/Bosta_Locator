package com.nourelden515.bostalocator.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class BaseDto<T>(
    @SerializedName("success")
    val success: Boolean,

    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val data: T
)
