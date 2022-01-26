package com.karthiksankar.actmobile.viewmodel.country

import com.karthiksankar.actmobile.data.Country

sealed class CountryPickerEvent {
    class QueryChange(val query: String) : CountryPickerEvent()
    class SelectCountry(val country: Country) : CountryPickerEvent()
}
