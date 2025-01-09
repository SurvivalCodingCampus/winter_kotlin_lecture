package day17.repository.store

import day17.mock_data_source.store.MockStoreDataSourceImpl
import kotlinx.coroutines.test.runTest
import org.example.day17.repository.store.StoreRepositoryImpl
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class StoreRepositoryImplTest {
    private val storeRepository = StoreRepositoryImpl(MockStoreDataSourceImpl())

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `주어진 API에서 Json 데이터가 정상적으로 나오는지 테스트`() = runTest {
        // emainStat, stockAt, createdAt이 null 또는 빈값인 경우 제외
        val test = storeRepository.getVailidStoreData()

        println(test)
        test.forEach {
            assertTrue(it.remainStat != "" && it.stockAt != "" && it.createdAt != "")
        }

        assertEquals("서울특별시 강북구 솔매로 38 (미아동)", test[0].addr)
        assertEquals("11817488", test[0].code)
        assertEquals("2020/07/03 11:00:00", test[0].createdAt)
        assertEquals(37.6254369, test[0].lat, 0.0000001)
        assertEquals(127.0164096, test[0].lng, 0.0000001)
        assertEquals("승약국", test[0].name)
        assertEquals("plenty", test[0].remainStat)
        assertEquals("2020/07/02 18:05:00", test[0].stockAt)
        assertEquals("unknown", test[0].type)

    }
}