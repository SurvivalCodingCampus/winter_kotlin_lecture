package day15.repository.todo

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.SerializationException
import org.example.day15.data_source.todo.MockTodoDataSourceImpl
import org.example.day15.repository.todo.TodoRepositoryImpl
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class TodoRepositoryImplTest {
    private val jsonWithInvalidField = """
        [
            {
                "id": 1,
                "title": "title1",
                "description": "description1",
                "isDone": "true"
                "invalidField": "invalidField"
            }
        ]
    """.trimIndent()

    private val invalidJson = """
        [
            {
                "id": 1,
                "title": "title1",
                "description": "description1",
                "isDone": "true"
            },
            {
                "id": 2,
                "title": "title2",
                "description": "description2",
                "isDone": "true
            }
        ]
    """.trimIndent()

    val validTodoRepositoryImpl = TodoRepositoryImpl(MockTodoDataSourceImpl())

    @Test
    fun getTodos(): Unit = runBlocking {
        val todos = validTodoRepositoryImpl.getTodos()
        assertTrue("할 일 정보는 200개 여야 한다.", todos.size == 200)
        assertTrue("첫번째 할 일의 id는 1이여야 한다.", todos.first().id == 1)

        val invalidTodoRepositoryImpl = TodoRepositoryImpl(MockTodoDataSourceImpl(jsonWithInvalidField))
        val todosWithInvalidField =
            assertDoesNotThrow("잘못된 필드가 있어도 default 객체를 반환 해야 한다.") { invalidTodoRepositoryImpl.getTodos() }
        assertTrue("할 일 정보는 1개 여야 한다.", todosWithInvalidField.size == 1)


        val errorTodoRepositoryImpl = TodoRepositoryImpl(MockTodoDataSourceImpl(invalidJson))

        launch {
            assertThrows<SerializationException> { errorTodoRepositoryImpl.getTodos() }
        }.start()
    }

    @Test
    fun getCompletedTodos() = runBlocking {
        val todos = validTodoRepositoryImpl.getCompletedTodos()
        assertTrue("완료된 할 일 정보는 90개 여야 한다.", todos.size == 90)

        assertTrue("가져온 할 일 정보 중 하나라도 완료되지 않은 할 일이 있으면 안된다.", todos.all { it.completed })

    }

}