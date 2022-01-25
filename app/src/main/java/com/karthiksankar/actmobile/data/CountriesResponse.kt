package com.karthiksankar.actmobile.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CountriesResponse(
    @SerializedName("code") val code: Int,
    @SerializedName("result") val result: List<Country>
) : Serializable
