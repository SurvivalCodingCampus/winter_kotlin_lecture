package day15

import day14.Todo
import io.ktor.client.engine.mock.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.test.runTest
import org.example.day15.Utils.format
import org.example.day16.utils.ApiClient
import org.junit.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals


class ImageRepositoryTest {
    @Test
    fun `comment mock test`(): Unit = runTest {

        val mockEngine = MockEngine { request ->
            when (request.url.toString()) {
                "https://test.com/image1.png" -> {
                    respond(
                        content = ByteReadChannel(byteArrayOf(1, 2, 3)),
                        status = HttpStatusCode.OK,
                        headers = headersOf("Content-Type", "image/png")
                    )
                }

                "https://test.come/error.png" -> {
                    respond(
                        content = ByteReadChannel("Error"), status = HttpStatusCode.NotFound
                    )
                }

                else -> {
                    respond(
                        content = ByteReadChannel(byteArrayOf()), status = HttpStatusCode.NotFound
                    )
                }

            }

        }

        val url =
            "https://i.namu.wiki/i/SHy-nIaIdngguW7ogbR_8pyC77wGRmt29YH_41AIte4Clm0FuMBWGh1UNv2SkL-YdYw_R12KoQng7Jjv2MK9o5Qqljbwg5OuBRS9mak1sOrC-usitcnz1tdK8FOcRjbH0mzeoS25ghkdZX5rejCIug.webp"

        val mockClient = ApiClient(mockEngine).create()
        val mockResponse = mockClient.get("https://test.com/image1.png")

        assertContentEquals(byteArrayOf(1, 2, 3), mockResponse.bodyAsBytes())


    }

    @Test
    fun `todo mock test`(): Unit = runTest {


        val jsonData = """
        [
            {
                "userId": 1,
                "id": 1,
                "title": "delectus aut autem",
                "completed": false
            }
         ]
            
        """.trimIndent()

        val mockEngine = MockEngine { request ->
            when (request.url.toString()) {
                "https://jsonplaceholder.typicode.com/todos" -> {
                    respond(
                        content = jsonData, status = HttpStatusCode.OK, headers = headersOf("Content-Type", "text/xml")
                    )
                }

                "https://test.come/error.png" -> {
                    respond(
                        content = ByteReadChannel("Error"), status = HttpStatusCode.NotFound
                    )
                }

                else -> {
                    respond(
                        content = ByteArray(1), status = HttpStatusCode.NotFound
                    )
                }

            }

        }


        val client = ApiClient(mockEngine).create()
        val response = client.get("https://jsonplaceholder.typicode.com/todos")

        val mockResponse = format.decodeFromString<List<Todo>>(response.bodyAsText())
        val result = format.decodeFromString<List<Todo>>(jsonData)


        mockResponse.forEachIndexed { index, todo ->
            assertEquals(todo.id, result[index].id)
            assertEquals(todo.title, result[index].title)
            assertEquals(todo.userId, result[index].userId)
            assertEquals(todo.completed, result[index].completed)
        }

    }
}

