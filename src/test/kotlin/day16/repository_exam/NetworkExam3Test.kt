package day16.repository_exam

import kotlinx.coroutines.runBlocking
import org.example.day16.repository_exam.data_source.image.ImageDataSourceImpl
import org.example.day16.repository_exam.model.image.DownloadInfo
import org.example.day16.repository_exam.repository.image.ImageRepositoryImpl
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import java.io.File
import kotlin.system.measureNanoTime

class NetworkExam3Test {
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
        assertEquals(false, File("${directory}/도지18.txt").exists())

        val downloadInfo = imageRepository.saveImage(url, "${directory}/도지18.txt")

        // 이미지가 다운이 됐는지 확인
        assertEquals(true, File("${directory}/도지18.txt").exists())
        // 입력한 경로대로 이미지 이름이 틀리지 않게 다운이 됐는지 확인
        assertEquals("도지18.txt", File("${directory}/도지18.txt").name)

        // DownloadInfo에 이미지를 다운할 때 저장한 데이터가 정확한지 확인
        assertEquals("다운로드 시작", downloadInfo.startTime)
        assertEquals("다운로드 끝", downloadInfo.endTime)
        // 소요시간은 정확한 측정이 불가
        assertEquals("용량 : 11195bytes", downloadInfo.fileSize)


        File("${directory}/도지18.txt").delete()
    }

    @Test
    fun `ImageRepositoryImpl의 saveImages() 테스트`(): Unit = runBlocking {
        // 테스트를 위해서 존재하지 않는 이미지로 테스트, 다음 테스트를 위해 테스트 종료 전에 다운한 이미지 삭제
        assertEquals(false, File("${directory}/도지11.txt").exists())
        assertEquals(false, File("${directory}/도지12.txt").exists())
        assertEquals(false, File("${directory}/도지13.txt").exists())
        assertEquals(false, File("${directory}/도지14.txt").exists())
        assertEquals(false, File("${directory}/도지15.txt").exists())

        val downloadInfoList = imageRepository.saveImages(urls, directory)

        // DownloadInfo에 이미지를 다운할 때 저장한 데이터가 정확한지 확인
        assertEquals("다운로드 시작", downloadInfoList[0].startTime)
        assertEquals("다운로드 끝", downloadInfoList[0].endTime)
        // 소요시간은 정확한 측정이 불가
        assertEquals("용량 : 11195bytes", downloadInfoList[0].fileSize)


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

        // 존재하지 않는 이미지를 다운 성공 테스트
        val downloadInfo = imageRepository.saveImageIfNotExists(url, "${directory}/도지68.txt")
        assertEquals(true, File("${directory}/도지68.txt").exists())
        assertEquals(true, downloadInfo != null)

        // DownloadInfo에 이미지를 다운할 때 저장한 데이터가 정확한지 확인
        if (downloadInfo != null) {
            assertEquals("다운로드 시작", downloadInfo.startTime)
            assertEquals("다운로드 끝", downloadInfo.endTime)
            // 소요시간은 정확한 측정이 불가
            assertEquals("용량 : 11195bytes", downloadInfo.fileSize)
        }

        File("${directory}/도지68.txt").delete()
    }

    @Test
    fun `이미지가 존재할 때 ImageRepositoryImpl의 saveImageIfNotExists() 테스트`(): Unit = runBlocking {
        // 테스트를 위해서 테스트 시작시 이미지 다운, 다음 테스트를 위해 테스트 종료 전에 다운한 이미지 삭제
        imageRepository.saveImage(url, "${directory}/도지99.txt")
        assertEquals(true, File("${directory}/도지99.txt").exists())

        // 이미지가 존재해서 다운을 하지 않고 null 리턴
        val downloadInfo = imageRepository.saveImageIfNotExists(url, "${directory}/도지99.txt")
        assertEquals(null, downloadInfo)

        File("${directory}/도지99.txt").delete()
    }
}