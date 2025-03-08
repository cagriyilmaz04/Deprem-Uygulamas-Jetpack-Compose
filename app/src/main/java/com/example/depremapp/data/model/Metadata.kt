package com.example.depremapp.data.model

import com.google.gson.annotations.SerializedName

data class Metadata(
    @SerializedName("date_starts") val dateStarts: String,
    @SerializedName("date_ends") val dateEnds: String,
    val total: Int
)