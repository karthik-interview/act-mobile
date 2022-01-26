package com.karthiksankar.actmobile.data

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.karthiksankar.actmobile.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountriesRepo @Inject constructor(
    @ApplicationContext private val context: Context,
    private val countryPreference: CountryPreference,
    private val gson: Gson,
) {

    val countries: List<Country>
        get() {
            if (_countries.isEmpty()) {
                val rawData = context.resources.openRawResource(R.raw.countries).bufferedReader()
                    .use { it.readText() }
                _countries.clear()
                _countries.addAll(gson.fromJson(rawData, CountriesResponse::class.java).result)
            }

            return _countries
        }

    private val _countries: MutableList<Country> = mutableListOf()

    val selectedCountry: MutableState<Country> = mutableStateOf(getCurrentRegion())

    fun getCountryByCode(code: String): Country? {
        return countries.find { it.code == code }
    }

    fun setCurrentRegion(country: Country) {
        countryPreference.selectedCountryCode = country.code
        selectedCountry.value = country
    }

    private fun getCurrentRegion(): Country {
        return countries.find { it.code == countryPreference.selectedCountryCode }!!
    }
}