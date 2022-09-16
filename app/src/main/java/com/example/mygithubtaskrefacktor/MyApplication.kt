package com.example.mygithubtaskrefacktor

import android.app.Application
import com.example.mygithubtaskrefacktor.core.coreModule
import com.example.mygithubtaskrefacktor.feature_authentication.authenticationModule
import com.example.mygithubtaskrefacktor.feature_github.featureModule
import com.example.mygithubtaskrefacktor.starter.starterModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class MyApplication() : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(coreModule + authenticationModule + starterModule + featureModule)
        }

    }
}