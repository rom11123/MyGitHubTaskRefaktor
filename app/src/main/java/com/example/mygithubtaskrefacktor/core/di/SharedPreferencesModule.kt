package com.example.mygithubtaskrefacktor.core.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.mygithubtaskrefacktor.feature_authentication.data.SHARED_PREF
import org.koin.dsl.module

val sharedPreferencesModule = module {
    single { getSharedPrefs(androidApplication = get()) }
}

private fun getSharedPrefs(androidApplication: Application): SharedPreferences {
    return androidApplication.getSharedPreferences(
        SHARED_PREF,
        Context.MODE_PRIVATE
    )
}