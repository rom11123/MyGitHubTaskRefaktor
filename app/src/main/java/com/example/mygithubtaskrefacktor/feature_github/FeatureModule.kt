package com.example.mygithubtaskrefacktor.feature_github

import com.example.mygithubtaskrefacktor.feature_github.data.dataModule
import com.example.mygithubtaskrefacktor.feature_github.domain.doMainModule
import com.example.mygithubtaskrefacktor.feature_github.presentation.presentationModule

val featureModule = dataModule + doMainModule + presentationModule


