package com.karthiksankar.actmobile.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.karthiksankar.actmobile.navigator.Screen
import com.karthiksankar.actmobile.navigator.countryGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HostActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActMobileScreen {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.startDestination.route
                ) {
                    countryGraph(navController)
                }
            }
        }
    }
}
