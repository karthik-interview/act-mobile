package com.karthiksankar.actmobile.data

import android.content.Context
import com.google.gson.Gson
import com.karthiksankar.actmobile.R

class CountriesRepo(
    private val context: Context,
    private val gson: Gson,
) {

    private val _countries = mutableListOf<Country>()

    fun getCountries(): List<Country> {
        if (_countries.isEmpty()) {
            val rawData = context.resources.openRawResource(R.raw.countries).bufferedReader()
                .use { it.readText() }
            _countries.clear()
            _countries.addAll(gson.fromJson(rawData, CountriesResponse::class.java).result)
        }

        return _countries
    }
}