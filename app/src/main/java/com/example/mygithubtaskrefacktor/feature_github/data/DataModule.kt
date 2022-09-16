package com.example.mygithubtaskrefacktor.feature_github.data

import com.example.mygithubtaskrefacktor.feature_github.data.datasource.dataSourceModule
import com.example.mygithubtaskrefacktor.feature_github.data.repository.repositoriesModule
import com.example.mygithubtaskrefacktor.feature_github.data.room.dataBaseModule

val dataModule = dataBaseModule + dataSourceModule + repositoriesModule