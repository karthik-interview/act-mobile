package com.karthiksankar.actmobile.ui.country

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.karthiksankar.actmobile.R
import com.karthiksankar.actmobile.data.Country
import com.karthiksankar.actmobile.ui.ActMobileScreen
import com.karthiksankar.actmobile.viewmodel.country.CountryPickerEvent
import com.karthiksankar.actmobile.viewmodel.country.CountryPickerEvent.QueryChange
import com.karthiksankar.actmobile.viewmodel.country.CountryPickerEvent.SelectCountry

@Composable
fun CountryPickerScreen(
    query: String,
    countries: List<Country>,
    eventMachine: (CountryPickerEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        SearchBox(
            query = query,
            placeholder = stringResource(id = R.string.placeholder_search_region),
            onQueryChange = { query -> eventMachine(QueryChange(query)) },
            clearSearch = { eventMachine(QueryChange("")) },
            onDone = { countries.firstOrNull()?.let { eventMachine(SelectCountry(it)) } },
            modifier = Modifier.fillMaxWidth(),
        )

        CountriesList(
            countries = countries,
            onClick = { country -> eventMachine(SelectCountry(country)) },
        )
    }
}

@Preview
@Composable
private fun PreviewCountryPickerScreen() {
    ActMobileScreen {
        CountryPickerScreen(
            query = "",
            countries = listOf(),
            eventMachine = {}
        )
    }
}
