package com.karthiksankar.actmobile.navigator

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.karthiksankar.actmobile.data.Country
import com.karthiksankar.actmobile.ui.country.picker.CountryPickerScreen
import com.karthiksankar.actmobile.ui.country.preference.CountrySettingsScreen

fun NavGraphBuilder.countryGraph() {
    composable(Screen.CountrySettings.route) {
        CountrySettingsScreen(selectedCountry = Country("IN", "India"))
    }

    composable(Screen.CountryPicker.route) {
        CountryPickerScreen(query = "", countries = listOf(), eventMachine = {})
    }
}