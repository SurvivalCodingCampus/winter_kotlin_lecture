package day16.data.mock

import io.ktor.client.engine.mock.*
import io.ktor.http.*
import org.example.day15.data.resource.BASE_URL

val mockEngine = MockEngine { request ->
    when (request.url.toString()) {
        "$BASE_URL/todos/0" -> {
            respondError(HttpStatusCode.BadRequest, "BadRequest")
        }

        "$BASE_URL/todos/1" -> {
            respond(
                content = todos[0],
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }

        "$BASE_URL/todos/200" -> {
            respond(
                content = todos[1],
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }

        "$BASE_URL/todos" -> {
            respond(
                content = "[${todos[0]}, ${todos[1]}]",
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }

        else -> {
            respondError(HttpStatusCode.NotFound)
        }
    }
}

private val todos = listOf(
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
            "userId": 10,
            "id": 200,
            "title": "todo2",
            "completed": false
        }
    """
)