package day03

import com.survivalcoding.com.survivalcoding.day15.Todo
import com.survivalcoding.com.survivalcoding.day15.TodoRepository
import org.junit.Test

class TodoTest {
    val mockTodoRepositoryImpl = object : TodoRepository {
        override fun getTodos(): List<Todo> {
            return listOf(
                Todo(),
                Todo(),
                Todo(),
                Todo(),
            )
        }

    }

    @Test
    fun todoRepositoryTest() {

    }
}

//private class MockTodoRepositoryImpl : TodoRepository {
//    override fun getTodos(): List<Todo> {
//        TODO("Not yet implemented")
//    }
//
//}