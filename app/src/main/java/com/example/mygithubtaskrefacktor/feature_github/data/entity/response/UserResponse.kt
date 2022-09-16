package com.example.mygithubtaskrefacktor.feature_github.data.entity.response;

import com.google.gson.annotations.SerializedName


data class UserResponse(
    @SerializedName("login")
    var username: String,
    var name: String,
    var email: String,

    )
