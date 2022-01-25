package com.karthiksankar.actmobile.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import com.karthiksankar.actmobile.R

object Shapes {
    @Composable
    fun medium() = RoundedCornerShape(dimensionResource(id = R.dimen.item_shape_corner))
}