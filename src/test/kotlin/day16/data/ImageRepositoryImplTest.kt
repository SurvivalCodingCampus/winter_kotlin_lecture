package day16.data

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test

class ImageRepositoryImplTest {

    @Test
    fun `DownloadInfo should take time`() = runTest {
        val expected = 1000L
        val fakeRepo = ImageRepositoryImpl(MockImageDataSource(expected))
        val info = fakeRepo.saveImage("url", "path")
        assertTrue(expected < info.elapsedTime.toDouble())
    }
}