package day14

import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DataSourceImplTest {

    @Test
    fun checkExist() {
        val todoDataSourceImpl = TodoDataSourceImpl()

        // runBlocking을 사용하여 suspend 함수 호출
        runBlocking {
            val todoList = todoDataSourceImpl.getTodo()
            assertTrue(todoList.isNotEmpty(), "Todo 리스트가 비어 있습니다.")
        }
    }

    @Test
    fun checkListSize() {
        val todoDataSource = TodoDataSourceImpl()
        runBlocking {
            val todoList = todoDataSource.getTodo()
            val expectedSize = 200
            assertEquals(expectedSize, todoList.size, "Todo 항목의 수가 잘못되었습니다.")
        }
    }
}