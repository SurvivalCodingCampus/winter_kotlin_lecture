package day16.util

import io.ktor.http.*

class HttpResponseException(val status: HttpStatusCode, message: String) : Exception(message)