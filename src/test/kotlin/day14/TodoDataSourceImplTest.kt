package day14

import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Assert
import org.junit.Test

class TodoDataSourceImplTest {
    @Test
    fun getTodos() = runTest {
        val todoSource = TodoDataSourceImpl()
        val expected = Json.decodeFromString<List<Todo>>(Data.TODO_STRING)
        Assert.assertEquals(expected, todoSource.getTodos())
    }
}