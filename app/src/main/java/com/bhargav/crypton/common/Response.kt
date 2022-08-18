package com.bhargav.crypton.common

sealed class Response<T>(val data: T? = null, val error: String? = null) {
    class Success<T>(data: T) : Response<T>(data)
    class Error<T>(error: String, data: T? = null) : Response<T>(data, error)
    class Loading<T>(data: T? = null) : Response<T>(data)
}
