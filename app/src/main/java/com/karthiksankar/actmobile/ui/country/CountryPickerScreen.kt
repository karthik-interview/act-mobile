package com.karthiksankar.actmobile.ui.country

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
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
        val focusRequester = FocusRequester()
        SearchBox(
            query = query,
            placeholder = stringResource(id = R.string.placeholder_search_region),
            onQueryChange = { query -> eventMachine(QueryChange(query)) },
            clearSearch = { eventMachine(QueryChange("")) },
            onDone = { countries.firstOrNull()?.let { eventMachine(SelectCountry(it)) } },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester),
        )

        if (countries.isNotEmpty()) {
            CountriesList(
                countries = countries,
                onClick = { country -> eventMachine(SelectCountry(country)) },
            )
        } else {
            EmptySearchResults(
                query = query,
                clearSearch = { eventMachine(QueryChange("")) },
                modifier = Modifier.fillMaxWidth()
            )
        }

        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }
}

@Composable
private fun EmptySearchResults(
    query: String,
    clearSearch: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.spacing_medium)),
    ) {
        Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.spacing_large)))
        Text(text = LocalContext.current.getString(R.string.empty_search_results, query))
        TextButton(onClick = clearSearch) {
            Text(text = stringResource(id = R.string.action_clear_search))
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
