package com.example.mygithubtaskrefacktor.core

import com.example.mygithubtaskrefacktor.core.di.coroutineModule
import com.example.mygithubtaskrefacktor.core.di.networkModule
import com.example.mygithubtaskrefacktor.core.di.sharedPreferencesModule

val coreModule = sharedPreferencesModule + coroutineModule + networkModule