package day16.repository_exam.data_source

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.day15.repository_exam.data_source.TodoDatasource
import org.example.day15.repository_exam.model.Todo
import org.example.day16.repository_exam.data_source.movie.MockMovieDataSourceImpl
import org.example.day16.repository_exam.repository.movie.MovieRepositoryImpl
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MockTodoDataSourceImpl : TodoDatasource {
//    val mockEngine = MockEngine { request ->
//        respond(
//            content = ByteReadChannel(),
//            status = HttpStatusCode.OK,
//            headers = headersOf(HttpHeaders.ContentType, "application/json")
//        )
//    }


    override suspend fun getTodo(userId: Int): Todo? {
        TODO("Not yet implemented")
    }

    override suspend fun saveTodo(todo: Todo) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllTodos(): List<Todo> {
        TODO("Not yet implemented")
    }
}