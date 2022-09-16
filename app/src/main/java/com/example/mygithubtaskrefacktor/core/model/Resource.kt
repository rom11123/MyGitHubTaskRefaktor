package com.example.mygithubtaskrefacktor.core.model

sealed class Resource<out RESOURCE_TYPE> {
    data class Success<out DATA_TYPE>(
        val data: DATA_TYPE
    ) : Resource<DATA_TYPE>()

    data class Failure<out DATA_TYPE>(
        val exception: Exception,
        val data: DATA_TYPE?,
        val code: Int? = null

    ) : Resource<DATA_TYPE>()

    data class Loading<out DATA_TYPE>(
        val data: DATA_TYPE?
    ) : Resource<DATA_TYPE>()
}