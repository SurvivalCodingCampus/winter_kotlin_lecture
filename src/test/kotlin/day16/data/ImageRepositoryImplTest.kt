package day16.data

import kotlinx.coroutines.test.runTest
import org.junit.Test

class ImageRepositoryImplTest {

    @Test
    fun `DownloadInfo should take time`() = runTest {
        val fakeRepo = ImageRepositoryImpl(MockImageDataSource())
    }
}