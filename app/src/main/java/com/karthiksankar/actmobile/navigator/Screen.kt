package com.karthiksankar.actmobile.navigator

sealed class Screen(val route: String) {
    object CountrySettings : Screen("country/settings")
    object CountryPicker : Screen("country/picker")

    companion object {
        val startDestination: Screen = CountrySettings
    }
}
