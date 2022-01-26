package com.karthiksankar.actmobile.viewmodel.country

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karthiksankar.actmobile.data.CountriesRepo
import com.karthiksankar.actmobile.data.Country
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryPickerVm @Inject constructor(
    private val countriesRepo: CountriesRepo,
) : ViewModel() {

    private val _query: MutableState<String> = mutableStateOf("")
    val query: State<String> get() = _query

    private val allCountries = countriesRepo.countries

    private val _countries: MutableState<List<Country>> = mutableStateOf(allCountries)
    val countries: State<List<Country>> = _countries

    private val _uiEffect = Channel<CountryPickerUiEffect>(Channel.BUFFERED)
    val uiEffect: Flow<CountryPickerUiEffect> get() = _uiEffect.receiveAsFlow()

    fun processEvents(event: CountryPickerEvent) = when (event) {
        is CountryPickerEvent.QueryChange -> searchCountry(event.query)
        is CountryPickerEvent.SelectCountry -> selectCountry(event.country)
    }


    private fun searchCountry(query: String) {
        _query.value = query
        _countries.value =
            allCountries.filter { it.name.contains(query, ignoreCase = true) }
    }

    private fun selectCountry(country: Country) {
        countriesRepo.setCurrentRegion(country)
        sendUiEffect(CountryPickerUiEffect.GoBack)
    }

    private fun sendUiEffect(effect: CountryPickerUiEffect) {
        viewModelScope.launch {
            _uiEffect.send(effect)
        }
    }
}