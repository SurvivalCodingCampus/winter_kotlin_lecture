package day17.repository

import day17.datasource.MockPhotoDataSourceImpl
import day17.model.PhotoType
import day17.utils.Const
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals


class PhotoRepositoryImplTest {

    private lateinit var photoRepositoryImpl: PhotoRepositoryImpl

    @Test
    fun `데이터 매핑이 잘 되는지`() = runTest {
        photoRepositoryImpl = PhotoRepositoryImpl(MockPhotoDataSourceImpl(Const.PHOTO_JSON))
        val firstData = photoRepositoryImpl.getUsePhotoData()
        assertEquals(3, firstData.size)

        photoRepositoryImpl = PhotoRepositoryImpl(MockPhotoDataSourceImpl(Const.SECOND_PHOTO_JSON))
        val secondData = photoRepositoryImpl.getUsePhotoData()
        assertEquals(3, secondData.size)
    }

    @Test
    fun `첫번째 JSON 변환 확인`() = runTest {
        photoRepositoryImpl = PhotoRepositoryImpl(MockPhotoDataSourceImpl(Const.PHOTO_JSON))
        val firstData = photoRepositoryImpl.getUsePhotoData()

        var result = true

        firstData.forEach { data ->
            when (data.type) {
                PhotoType.ARTICLE -> {}

                PhotoType.IMAGE -> {}

                PhotoType.VIDEO -> {}

                else -> {
                    result = false
                }
            }
        }

        assertEquals(true, result)
    }

    @Test
    fun `두번째 JSON 변환 확인`() = runTest {
        photoRepositoryImpl = PhotoRepositoryImpl(MockPhotoDataSourceImpl(Const.SECOND_PHOTO_JSON))
        val secondData = photoRepositoryImpl.getUsePhotoData()

        // Type 확인
        assertEquals(PhotoType.ARTICLE, secondData[0].type)
        assertEquals(PhotoType.UNKNOWN, secondData[1].type)
        assertEquals(PhotoType.UNKNOWN, secondData[2].type)
    }

    @Test
    fun `잘못된 JSON 형식 테스트`() = runTest {
        val invalidJson = """
                [
                    "id": 1,
                    "type": "article",
                    "created_at": "2024-01-09"
                ]
            """.trimIndent()


        photoRepositoryImpl = PhotoRepositoryImpl(MockPhotoDataSourceImpl(invalidJson))
        val result = photoRepositoryImpl.getUsePhotoData()

        // 에러 발생 시 빈 리스트 반환 확인
        assertEquals(0, result.size)
    }
}