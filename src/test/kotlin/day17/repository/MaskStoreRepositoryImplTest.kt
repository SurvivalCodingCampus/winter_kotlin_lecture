package day17.repository

import day17.mock.maskStoreMockEngine
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.example.day14.data.result.Result
import org.example.day14.data.result.asResult
import org.example.day14.util.jsonConfig
import org.example.day17.datasource.MaskStoreDataSourceImpl
import org.example.day17.repository.MaskStoreRepositoryImpl
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MaskStoreRepositoryImplTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    private val testScope = TestScope(UnconfinedTestDispatcher())
    private lateinit var subject: MaskStoreRepositoryImpl
    private lateinit var httpClient: HttpClient

    @Before
    fun setUp() {
        httpClient = HttpClient(maskStoreMockEngine) {
            install(ContentNegotiation) {
                json(jsonConfig)
            }
        }
        subject = MaskStoreRepositoryImpl(
            MaskStoreDataSourceImpl(
                httpClient
            )
        )
    }

    @Test
    fun getMaskStores() = testScope.runTest {
        subject.getMaskStores().asResult().filterNot { it == Result.Loading }.collect { result ->
            assertTrue(result is Result.Success)
            assertEquals(3, result.data.size)
        }
    }
}