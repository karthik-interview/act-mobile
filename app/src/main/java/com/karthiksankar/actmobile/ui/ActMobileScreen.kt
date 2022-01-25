package com.karthiksankar.actmobile.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.karthiksankar.actmobile.ui.theme.ActMobileTheme

@Composable
fun ActMobileScreen(
    content: @Composable () -> Unit
) {
    ActMobileTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}