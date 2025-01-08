package day16.repository_exam

import kotlinx.coroutines.runBlocking
import org.example.day16.repository_exam.data_source.image.ImageDataSourceImpl
import org.example.day16.repository_exam.repository.image.ImageRepositoryImpl
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import java.io.File

class NetworkExam2Test {
    private val imageRepository = ImageRepositoryImpl(ImageDataSourceImpl())
    private val url = "https://i.pinimg.com/474x/87/a1/a3/87a1a3111c93a554bc768df6e225238c.jpg"
    private val urls = File("image_urls.txt").readLines()
    private val directory = "image_test_directory"

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `ImageRepositoryImpl의 saveImage() 테스트`(): Unit = runBlocking {
        // 테스트를 위해서 존재하지 않는 이미지로 테스트, 다음 테스트를 위해 테스트 종료 전에 다운한 이미지 삭제
        assertEquals(false, File("${directory}/도지.txt").exists())

        imageRepository.saveImage(url, "${directory}/도지.txt")

        // 이미지가 다운이 됐는지 확인
        assertEquals(true, File("${directory}/도지.txt").exists())
        // 입력한 경로대로 이미지 이름이 틀리지 않게 다운이 됐는지 확인
        assertEquals("도지.txt", File("${directory}/도지.txt").name)

        File("${directory}/도지.txt").delete()
    }

    @Test
    fun `ImageRepositoryImpl의 saveImages() 테스트`(): Unit = runBlocking {
        // 테스트를 위해서 존재하지 않는 이미지로 테스트, 다음 테스트를 위해 테스트 종료 전에 다운한 이미지 삭제
        assertEquals(false, File("${directory}/도지11.txt").exists())
        assertEquals(false, File("${directory}/도지12.txt").exists())
        assertEquals(false, File("${directory}/도지13.txt").exists())
        assertEquals(false, File("${directory}/도지14.txt").exists())
        assertEquals(false, File("${directory}/도지15.txt").exists())

        imageRepository.saveImages(urls, directory)

        // 이미지가 원하는 디렉터리에 다운이 됐는지 확인, urls에 url이 5개 존재
        assertEquals(true, File("${directory}/도지11.txt").exists())
        assertEquals(true, File("${directory}/도지12.txt").exists())
        assertEquals(true, File("${directory}/도지13.txt").exists())
        assertEquals(true, File("${directory}/도지14.txt").exists())
        assertEquals(true, File("${directory}/도지15.txt").exists())

        // 입력한 디렉터리에 이미지 이름이 틀리지 않게 다운이 됐는지 확인
        assertEquals("도지11.txt", File("${directory}/도지11.txt").name)
        assertEquals("도지12.txt", File("${directory}/도지12.txt").name)
        assertEquals("도지13.txt", File("${directory}/도지13.txt").name)
        assertEquals("도지14.txt", File("${directory}/도지14.txt").name)
        assertEquals("도지15.txt", File("${directory}/도지15.txt").name)

        File("${directory}/도지11.txt").delete()
        File("${directory}/도지12.txt").delete()
        File("${directory}/도지13.txt").delete()
        File("${directory}/도지14.txt").delete()
        File("${directory}/도지15.txt").delete()
    }

    @Test
    fun `이미지가 존재하지 않을 때 ImageRepositoryImpl의 saveImageIfNotExists() 테스트`(): Unit = runBlocking {
        // 테스트를 위해서 존재하지 않는 이미지로 테스트, 다음 테스트를 위해 테스트 종료 전에 다운한 이미지 삭제
        assertEquals(false, File("${directory}/도지6.txt").exists())

        // 존재하지 않는 이미지를 다운
        assertEquals(true, imageRepository.saveImageIfNotExists(url, "${directory}/도지6.txt"))

        // 이미지가 원하는 경로에 다운이 됐는지 확인
        assertEquals(true, File("${directory}/도지6.txt").exists())

        // 입력한 경로에 파일 이름이 틀리지 않게 다운이 됐는지 확인
        assertEquals("도지6.txt", File("${directory}/도지6.txt").name)

        File("${directory}/도지6.txt").delete()
    }

    @Test
    fun `이미지가 존재할 때 ImageRepositoryImpl의 saveImageIfNotExists() 테스트`(): Unit = runBlocking {
        // 테스트를 위해서 테스트 시작시 이미지 다운, 다음 테스트를 위해 테스트 종료 전에 다운한 이미지 삭제
        imageRepository.saveImage(url, "${directory}/도지99.txt")
        assertEquals(true, File("${directory}/도지99.txt").exists())

        // 이미지가 존재해서 다운을 하지 않고 false를 리턴
        assertEquals(false, imageRepository.saveImageIfNotExists(url, "${directory}/도지99.txt"))

        File("${directory}/도지99.txt").delete()
    }
}