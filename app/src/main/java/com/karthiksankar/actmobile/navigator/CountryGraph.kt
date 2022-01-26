package com.karthiksankar.actmobile.navigator

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.karthiksankar.actmobile.ui.country.CountryPickerScreen
import com.karthiksankar.actmobile.ui.country.CountrySettingsScreen
import com.karthiksankar.actmobile.viewmodel.country.CountrySettingsVm

fun NavGraphBuilder.countryGraph(navController: NavController) {
    composable(Screen.CountrySettings.route) {
        val viewModel: CountrySettingsVm = hiltViewModel()
        CountrySettingsScreen(
            selectedCountry = viewModel.selectCountry.value,
            changeCountry = { navController.navigate(Screen.CountryPicker.route) },
            modifier = Modifier.fillMaxSize(),
        )
    }

    composable(Screen.CountryPicker.route) {
        CountryPickerScreen(query = "", countries = listOf(), eventMachine = {})
    }
}