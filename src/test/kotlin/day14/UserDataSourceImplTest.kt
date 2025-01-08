package day14

import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Assert
import org.junit.Test

class UserDataSourceImplTest {

    @Test
    fun getTodos() = runTest {
        val userSource = UserDataSourceImpl()
        val expected = Json.decodeFromString<List<User>>(Data.USER_STRING)
        Assert.assertEquals(expected, userSource.getUsers())
    }
}