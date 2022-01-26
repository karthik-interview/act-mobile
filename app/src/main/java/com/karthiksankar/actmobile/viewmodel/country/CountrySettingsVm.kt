package com.karthiksankar.actmobile.viewmodel.country

import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import com.karthiksankar.actmobile.data.CountriesRepo
import com.karthiksankar.actmobile.data.Country
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CountrySettingsVm @Inject constructor(
    private val countriesRepo: CountriesRepo,
) : ViewModel() {

    val selectCountry: State<Country> get() = countriesRepo.selectedCountry
}