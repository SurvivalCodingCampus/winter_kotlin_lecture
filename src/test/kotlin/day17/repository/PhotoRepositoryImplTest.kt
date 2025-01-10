package day17.repository

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.example.day17.datasource.MockPhotoSourceImpl
import org.example.day17.model.Type
import org.example.day17.repository.PhotoRepositoryImpl
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class PhotoRepositoryImplTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    private val testScope = TestScope(UnconfinedTestDispatcher())
    private lateinit var subject: PhotoRepositoryImpl

    @Before
    fun setUp() {
        subject = PhotoRepositoryImpl(
            MockPhotoSourceImpl()
        )
    }

    @Test
    fun getPhotoById() = testScope.runTest {
        assertFailsWith<NoSuchElementException> {
            subject.getPhotoById(0)
        }
        assertEquals(1, subject.getPhotoById(1).id)
        assertEquals(3, subject.getPhotoById(3).id)
    }

    @Test
    fun getPhotosByType() = testScope.runTest {
        subject.getPhotosByType(Type.ARTICLE).forEach {
            assertEquals(it.type, Type.ARTICLE)
        }
    }
}