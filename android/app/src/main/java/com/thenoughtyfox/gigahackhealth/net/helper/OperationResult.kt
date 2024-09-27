package com.thenoughtyfox.gigahackhealth.net.helper

import org.openapitools.client.infrastructure.getErrorResponse
import retrofit2.Response
import java.lang.Exception

sealed class OperationResult<out T> {

    class ResultSuccess<T>(val result: T) : OperationResult<T>()
    class ResultError(val error: String) : OperationResult<Nothing>()

    suspend fun onSuccess(func: suspend (T) -> Unit): OperationResult<T> {
        if (this is ResultSuccess) func(result)
        return this
    }

    suspend fun onError(func: suspend (String) -> Unit): OperationResult<T> {
        if (this is ResultError) func(error)
        return this
    }
}

fun <T, R> Response<T>.toOperationResult(
    onSuccess: (T) -> R
): OperationResult<R> {
    val body = body()
    val badMsg = "Oops something went wrong please try again"
    val error = try {
        getErrorResponse<ErrorResponse>()?.message ?: badMsg
    } catch (_: Exception) {
        badMsg
    }
    return when {
        isSuccessful && body != null -> OperationResult.ResultSuccess(onSuccess(body))
        errorBody() != null -> OperationResult.ResultError(error)
        else -> OperationResult.ResultError(badMsg)
    }
}

data class ErrorResponse(
    val statusCode: Int,
    val message: String,
    val timeStamp: String
)