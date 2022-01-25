package com.karthiksankar.actmobile.ui.picker

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                .clip(RoundedCornerShape(12.dp))
                .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(12.dp))
                .clickable { changeCountry() }
                .padding(16.dp)
        )
    }
}

@Preview
@Composable
private fun PreviewChosenCountry() {
    ActMobileScreen {
        ChosenCountry(
            country = Country("IN", "India"),
            changeCountry = { /*TODO*/ },
        )
    }
}
