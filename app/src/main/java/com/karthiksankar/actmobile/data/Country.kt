package com.karthiksankar.actmobile.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Country(
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String,
) : Serializable
