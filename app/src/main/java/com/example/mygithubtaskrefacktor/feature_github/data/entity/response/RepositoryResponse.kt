package com.example.mygithubtaskrefacktor.feature_github.data.entity.response;


import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.RepositoryEntity
import com.google.gson.annotations.SerializedName


data class RepositoryResponse (
    val id: Int,
    val name: String,
    @SerializedName("private")
    val isPrivate: Boolean,
    val language: String
        )


fun RepositoryResponse.toEntity(): RepositoryEntity {
    return RepositoryEntity(
        id = id,
        name = name,
        isPrivate = isPrivate,
        language = language
    )
}
