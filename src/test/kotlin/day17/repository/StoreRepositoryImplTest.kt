package day17.repository

import day17.datasource.MockStoreDataStore
import day17.model.Store
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class StoreRepositoryImplTest {
    @Test
    fun `store remaining stock doesn't have unknown value`() = runTest {
        val repo = StoreRepositoryImpl(MockStoreDataStore())
        Assert.assertEquals(0, repo.getAll().map { it.remaining }.filter { it == Store.Amount.UNKNOWN }.size)
    }
}