package day17.repository

import day17.dataSource.MaskStoreDataSource
import day17.dataSource.MockMaskStoreDataSourceImpl
import day17.dto.MaskStoreDto
import day17.model.Pharmacy
//import day17.dto.Pharmacy
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MaskStoreRepositoryImplTest {
    private val mockDataSource = MockMaskStoreDataSourceImpl()
    private val repository = MaskStoreRepositoryImpl(mockDataSource)

    @Test
    fun checkGetValidStore() = runTest {
        val result: List<day17.model.Pharmacy> = repository.getValidStore()
        assertEquals(2, result.size)

        result.forEach {
            assertTrue { it.remainStat.isNotEmpty() }
            assertTrue { it.stockAt.isNotEmpty() }
            assertTrue { it.createdAt.isNotEmpty() }
        }
    }

//    @Test
//    fun `빈 스토어 목록 처리 테스트`() = runTest {
//        val emptyDataSource = MockMaskStoreDataSourceImpl(emptyList())
//        val repository = MaskStoreRepositoryImpl(emptyDataSource)
//        val result = repository.getValidStore()
//        assertTrue(result.isEmpty())
//    }
//
//    @Test
//    fun `일부 필드가 null인 데이터 필터링 테스트`() = runTest {
//        val invalidDataSource = MockMaskStoreDataSourceImpl(listOf(
//            Pharmacy(remainStat = null, stockAt = "time", createdAt = "time"),
//            Pharmacy(remainStat = "some", stockAt = null, createdAt = "time")
//        ))
//        val repository = MaskStoreRepositoryImpl(invalidDataSource)
//        val result = repository.getValidStore()
//        assertTrue(result.isEmpty())
//    }
//
//    @Test
//    fun `에러 케이스 처리 테스트`() = runTest {
//        val errorProneDataSource = object : MaskStoreDataSource {
//            override suspend fun getStores(): MaskStoreDto {
//                throw Exception("네트워크 오류")
//            }
//
//            override suspend fun getStore(name: String): day17.dto.Pharmacy? {
//                throw Exception("네트워크 오류")
//            }
//        }
//        val repository = MaskStoreRepositoryImpl(errorProneDataSource)
//
//        try {
//            repository.getValidStore()
//            assertTrue(false) // 이 코드에 도달하면 실패
//        } catch (e: Exception) {
//            assertTrue(e.message?.contains("네트워크 오류") == true)
//        }
//    }


}

// todo 빈 목록 반환 케이스
// todo 일부 필드가 null인 데이터 처리
// todo 에러 케이스 처리