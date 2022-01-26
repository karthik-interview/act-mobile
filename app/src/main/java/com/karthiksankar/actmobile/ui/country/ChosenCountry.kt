package com.karthiksankar.actmobile.ui.country

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.karthiksankar.actmobile.R
import com.karthiksankar.actmobile.data.Country
import com.karthiksankar.actmobile.ui.ActMobileScreen

@Composable
fun ChosenCountry(
    country: Country,
    changeCountry: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        CountryItem(
            country = country,
            modifier = Modifier
                .clip(MaterialTheme.shapes.large)
                .border(
                    width = dimensionResource(id = R.dimen.item_border),
                    color = Color.Black,
                    shape = MaterialTheme.shapes.large,
                )
                .clickable { changeCountry() }
                .padding(dimensionResource(id = R.dimen.spacing_large))
        )
    }
}

@Preview
@Composable
private fun PreviewChosenCountry() {
    ActMobileScreen {
        ChosenCountry(
            country = Country("IN", "India"),
            changeCountry = {},
        )
    }
}
