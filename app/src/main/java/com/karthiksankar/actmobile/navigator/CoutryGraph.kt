package com.karthiksankar.actmobile.navigator

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.karthiksankar.actmobile.data.Country
import com.karthiksankar.actmobile.ui.country.CountryPickerScreen
import com.karthiksankar.actmobile.ui.country.CountrySettingsScreen

fun NavGraphBuilder.countryGraph(navController: NavController) {
    composable(Screen.CountrySettings.route) {
        CountrySettingsScreen(
            selectedCountry = Country("IN", "India"),
            changeCountry = { navController.navigate(Screen.CountryPicker.route) }
        )
    }

    composable(Screen.CountryPicker.route) {
        CountryPickerScreen(query = "", countries = listOf(), eventMachine = {})
    }
}