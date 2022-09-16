package com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity;

import com.google.gson.annotations.SerializedName


data class UserEntity(
    @SerializedName("login")
    var username: String,
    var name: String,
    var email: String,

    )
