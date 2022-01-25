package com.karthiksankar.actmobile.ui.country

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.karthiksankar.actmobile.R
import com.karthiksankar.actmobile.data.Country
import com.karthiksankar.actmobile.ui.ActMobileScreen

@Composable
fun CountryItem(
    country: Country,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.spacing_medium))
            .then(modifier),
    ) {
        Image(
            // TODO Update this with dynamic image resource
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier.size(dimensionResource(id = R.dimen.country_image_size))
        )
        Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.spacing_large)))
        Text(
            text = country.name,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview
@Composable
private fun PreviewCountryItem() {
    ActMobileScreen {
        CountryItem(Country("IN", "India"))
    }
}