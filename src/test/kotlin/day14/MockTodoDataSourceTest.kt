package day14

import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Assert
import org.junit.Test

class MockTodoDataSourceTest {
    @Test
    fun getTodos() = runTest {
        val todoSource = MockTodoDataSource()
        val expected = Json.decodeFromString<List<Todo>>(Data.TODO_STRING)
        Assert.assertEquals(expected, todoSource.getTodos())
    }
}