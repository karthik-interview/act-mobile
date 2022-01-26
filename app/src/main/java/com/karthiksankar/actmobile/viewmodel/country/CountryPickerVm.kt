package com.karthiksankar.actmobile.viewmodel.country

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.karthiksankar.actmobile.data.CountriesRepo
import com.karthiksankar.actmobile.data.Country
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CountryPickerVm @Inject constructor(
    countriesRepo: CountriesRepo,
) : ViewModel() {

    private val _query: MutableState<String> = mutableStateOf("")
    val query: State<String> get() = _query

    private val allCountries = countriesRepo.countries

    private val _countries: MutableState<List<Country>> = mutableStateOf(allCountries)
    val countries: State<List<Country>> = _countries

    fun processEvents(event: CountryPickerEvent) {
        when (event) {
            is CountryPickerEvent.QueryChange -> {
                _query.value = event.query
                _countries.value =
                    allCountries.filter { it.name.contains(event.query, ignoreCase = true) }
            }
            is CountryPickerEvent.SelectCountry -> {
                // TODO Pending implementation
            }
        }
    }
}