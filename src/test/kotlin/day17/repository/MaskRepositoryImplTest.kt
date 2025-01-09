package day17.repository

import day17.datasource.MaskDataSourceImpl
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals


class MaskRepositoryImplTest {

    private lateinit var maskRepositoryImpl: MaskRepositoryImpl

    @BeforeEach
    fun setUp() {
        maskRepositoryImpl = MaskRepositoryImpl(MaskDataSourceImpl())
    }

    @Test
    fun `MASK 데이터 Mapper 테스트`() = runTest {

        val data = maskRepositoryImpl.getUseStoreData()

        assertEquals(216, data.size)
    }


    @Test
    fun `변환한 데이터에 remainStat, stockAt, createdAt가 빈값으로 포함되어 있는지 확인`() = runTest {
        val data = maskRepositoryImpl.getUseStoreData()

        var isPass: Boolean = true

        data.forEach {
            if (it.stockAt.isBlank() || it.remainStat.isBlank() || it.createdAt.isBlank()) isPass = false
        }

        assertEquals(true, isPass)
    }
}