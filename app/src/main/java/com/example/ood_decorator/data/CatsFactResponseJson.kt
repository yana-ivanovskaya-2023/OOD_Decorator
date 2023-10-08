package com.example.ood_decorator.data

import com.google.gson.annotations.SerializedName

data class CatsFactResponseJson(
    @SerializedName("fact")
    val fact: String,
    @SerializedName("length")
    val length: Int
)