package day14

import io.kotest.common.runBlocking
import org.example.day14.todo.TodoHttpRepositoryImpl
import org.junit.Test
import kotlin.test.assertTrue

class TodoDatabaseImplTest {
    val todoDatabaseImpl: TodoHttpRepositoryImpl = TodoHttpRepositoryImpl()

    @Test
    fun getTodo(): Unit = runBlocking {
        val todoId = 1
        val data = todoDatabaseImpl.getTodo(id = 1)

        assertTrue("가져온 Todo의 id는 $todoId 여야 한다.") { data.id == todoId }
    }

}