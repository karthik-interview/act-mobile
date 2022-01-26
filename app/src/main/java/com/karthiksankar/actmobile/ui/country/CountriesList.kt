package com.karthiksankar.actmobile.ui.country

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.karthiksankar.actmobile.R
import com.karthiksankar.actmobile.data.Country

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CountriesList(
    countries: List<Country>,
    onClick: (Country) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier,
    ) {
        item {
            Spacer(Modifier.size(0.dp))
        }
        itemsIndexed(
            items = countries,
            key = { _, country -> country.code },
        ) { _, country ->
            Column(
                modifier = Modifier
                    .padding(horizontal = dimensionResource(id = R.dimen.spacing_large))
                    .animateItemPlacement()
            ) {
                CountryItem(
                    country = country,
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.medium)
                        .clickable { onClick(country) }
                        .padding(dimensionResource(id = R.dimen.spacing_medium)),
                )
            }
        }
    }
}