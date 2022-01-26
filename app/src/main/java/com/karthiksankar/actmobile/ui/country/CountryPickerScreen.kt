package com.karthiksankar.actmobile.ui.country

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    Column(modifier) {
        TextField(
            value = query,
            onValueChange = { query -> eventMachine(QueryChange(query)) },
        )

        LazyColumn {
            itemsIndexed(
                items = countries,
                key = { _, country -> country.code },
            ) { _, country ->
                CountryItem(
                    country = country,
                    modifier = Modifier.clickable { eventMachine(SelectCountry(country)) },
                )
                Divider()
            }
        }
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
