package com.karthiksankar.actmobile.ui.picker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.karthiksankar.actmobile.R
import com.karthiksankar.actmobile.data.Country
import com.karthiksankar.actmobile.ui.ActMobileScreen

@Composable
fun CountryScreen(
    selectedCountry: Country,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        Text(
            text = stringResource(id = R.string.title_your_region),
            style = MaterialTheme.typography.titleLarge,
        )

        ChosenCountry(
            country = selectedCountry,
            changeCountry = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(.75f)
        )
    }
}

@Preview
@Composable
private fun PreviewCountryScreen() {
    ActMobileScreen {
        CountryScreen(
            Country("IN", "India"),
            Modifier.fillMaxSize()
        )
    }
}