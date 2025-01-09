package org.example.day16.repository_exam.repository.image

import org.example.day16.repository_exam.data_source.image.ImageDataSource
import org.example.day16.repository_exam.model.image.DownloadInfo
import java.io.File
import kotlin.system.measureNanoTime

class ImageRepositoryImpl(private val dataSource: ImageDataSource) : ImageRepository {
    override suspend fun saveImage(url: String, path: String): DownloadInfo {
        var image: ByteArray

        val time = measureNanoTime {
            image = dataSource.fetchImage(url)
            dataSource.saveImage(image, path)
        }

        return getDownLoadInfo(time, image.size)
    }

    override suspend fun saveImages(urls: List<String>, directory: String): List<DownloadInfo> {
        // 디렉토리는 root에 있는 디렉토리라고 가정
        val path = "${directory}/도지1"
        val timeList: MutableList<DownloadInfo> = mutableListOf()


        for (i: Int in 1..urls.size) {

            val downloadInfo = saveImageIfNotExists(urls[i - 1], path + "${i}.jpg")

            if (downloadInfo != null) timeList.add(downloadInfo)
        }

        return timeList
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): DownloadInfo? {
        if (!File(path).exists()) {
            var image: ByteArray
            val time = measureNanoTime {
                image = dataSource.fetchImage(url)
                dataSource.saveImage(image, path)
            }
            return getDownLoadInfo(time, image.size)
        } else {
            return null
        }
    }

    private fun getDownLoadInfo(time: Long, imageSize: Int): DownloadInfo {
        val hour = time / 1000000000 / 60 / 60
        val min = (time / 1000000000 / 60) - (hour * 60)
        val sec = (time / 1000000000) - (((hour * 60) + min) * 60)
        val millis = (time / 1000) - (((hour * 60 * 60) + (min * 60) + sec) * 1000000)
        var minString = ""
        var secString = ""

        when (min.toString().length) {
            1 -> minString = "0$min"
        }

        when (sec.toString().length) {
            1 -> secString = "0$sec"
        }

        return when (millis.toString().length) {
            1 -> DownloadInfo(
                "다운로드 시작",
                "다운로드 끝",
                "소요시간 : $hour:$minString:$secString.00000$millis",
                "용량 : ${imageSize}bytes"
            )

            2 -> DownloadInfo(
                "다운로드 시작",
                "다운로드 끝",
                "소요시간 : $hour:$minString:$secString.0000$millis",
                "용량 : ${imageSize}bytes"
            )

            3 -> DownloadInfo(
                "다운로드 시작",
                "다운로드 끝",
                "소요시간 : $hour:$minString:$secString.000$millis",
                "용량 : ${imageSize}bytes"
            )

            4 -> DownloadInfo(
                "다운로드 시작",
                "다운로드 끝",
                "소요시간 : $hour:$minString:$secString.00$millis",
                "용량 : ${imageSize}bytes"
            )

            5 -> DownloadInfo(
                "다운로드 시작",
                "다운로드 끝",
                "소요시간 : $hour:$minString:$secString.0$millis",
                "용량 : ${imageSize}bytes"
            )

            else -> DownloadInfo(
                "다운로드 시작",
                "다운로드 끝",
                "소요시간 : $hour:$minString:$secString.$millis",
                "용량 : ${imageSize}bytes"
            )
        }
    }
}