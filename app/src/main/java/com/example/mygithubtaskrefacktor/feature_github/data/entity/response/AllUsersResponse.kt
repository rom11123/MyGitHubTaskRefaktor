package com.example.mygithubtaskrefacktor.feature_github.data.entity.response;


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AllUsersResponse(
    @SerializedName("avatar_url")
    val avatarUrl: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("login")
    val login: String?,
) : Serializable

