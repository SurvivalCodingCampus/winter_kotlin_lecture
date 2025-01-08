package day16.util

import io.ktor.client.engine.mock.*
import io.ktor.http.*


val mockEngine = MockEngine { request ->
    when (request.url.toString()) {
        "https://jsonplaceholder.typicode.com/todos/1" -> {
            respond(
                content = mockTodos[0].toByteArray(),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }

        "http://jsonplaceholder.typicode.com/todos" -> {
            respond(
                content = "[${mockTodos[0]}, ${mockTodos[1]}]".toByteArray(),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }

        else -> {
            respondBadRequest()
        }
    }
}

val mockTodos = listOf(
    """
    {
    "userId": 1,
    "id": 1,
    "title": "todo1",
    "completed": false
    }
    """,
    """
    {
    "userId": 1,
    "id": 2,
    "title": "todo2",
    "completed": true
    }
    """
)