package com.karthiksankar.actmobile.ui.country

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
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
        modifier = modifier,
    ) {
        Image(
            painter = rememberImagePainter(
                data = country.imageUrl,
                builder = {
                    crossfade(true)
                },
            ),
            contentDescription = null,
            modifier = Modifier.size(
                width = dimensionResource(id = R.dimen.country_image_width),
                height = dimensionResource(id = R.dimen.country_image_height),
            )
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