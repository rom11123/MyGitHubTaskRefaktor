package com.example.mygithubtaskrefacktor.core.repository

import com.example.mygithubtaskrefacktor.core.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.lang.Exception
import java.net.UnknownHostException

fun <RESPONSE, RESULT> safeApiCall(
    apiCall: suspend () -> Response<RESPONSE>,
    map: (RESPONSE) -> RESULT,
    getFromDb: suspend () -> RESULT,
    insert: suspend (RESULT) -> Unit
): Flow<Resource<RESULT>> = flow {
    emit(Resource.Loading(null))
    try {
        val responseResult = apiCall.invoke()
        if (responseResult.isSuccessful) {
            responseResult.body()?.let {
                insert(map(it))
                emit(Resource.Success(getFromDb()))
            }
        } else {
            emit(
                Resource.Failure(
                    Exception("Error"),getFromDb(), responseResult.code())
            )
        }
    } catch (t: Throwable) {
        val exception = when (t) {
            is UnknownHostException -> {
                NetworkConnectionException("Can not connect to network")
            }
            else -> {
                Exception("Could not fetch from network")
            }
        }
        emit(Resource.Failure(exception = exception, getFromDb.invoke()))
    }
}

fun <RESPONSE, RESULT> safeApiCallFlow(
    apiCall: suspend () -> Response<RESPONSE>,
    map: (RESPONSE) -> RESULT
): Flow<Resource<RESULT>> = flow {
    try {
        emit(Resource.Loading(null))
        val responseResult = apiCall.invoke()
        if (responseResult.isSuccessful) {
            responseResult.body()?.let {
                emit(Resource.Success(map(it)))
            }
        } else {
            emit(
                Resource.Failure(
                    Exception("Error"),null, responseResult.code())
            )
        }
    } catch (t: Throwable) {
        val exception = when (t) {
            is UnknownHostException -> {
                NetworkConnectionException("Can not connect to network")
            }
            else -> {
                Exception("Could not fetch from network")
            }
        }
        emit(Resource.Failure(exception = exception, null))
    }
}