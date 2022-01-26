package com.karthiksankar.actmobile.data

import android.content.Context
import com.chibatching.kotpref.KotprefModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountryPreference @Inject constructor(
    @ApplicationContext context: Context,
) : KotprefModel(context) {

    var selectedCountryCode: String by stringPref(default = "IN", key = "selectedCountryCode")
}