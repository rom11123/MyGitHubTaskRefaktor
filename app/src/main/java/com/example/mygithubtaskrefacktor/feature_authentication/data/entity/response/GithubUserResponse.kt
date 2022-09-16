package com.example.mygithubtaskrefacktor.feature_authentication.data.entity.response

import com.google.gson.annotations.SerializedName

data class GithubUserResponse(
    @SerializedName("login")
    val login: String?,
    var name: String,
    var email: String,
    @SerializedName("url")
    val url: String?,
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String?,
    @SerializedName("followers")
    val followers: Int?,
    @SerializedName("following")
    val following: Int?
) {
}



