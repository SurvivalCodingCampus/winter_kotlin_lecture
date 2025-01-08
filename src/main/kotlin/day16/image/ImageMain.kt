package org.hyunjung.day16.image

import kotlinx.coroutines.runBlocking
import org.hyunjung.day16.ApiModule
import org.hyunjung.day16.image.datasource.ImageDataSourceImpl
import org.hyunjung.day16.image.repository.ImageRepositoryImpl


fun main() = runBlocking {
    val client = ApiModule.create()
    val dataSource = ImageDataSourceImpl(client)
    val repository = ImageRepositoryImpl(dataSource)

    // 단일 이미지 다운로드 및 저장
    val imageUrl =
        "https://community-media.linkareer.com/55668?Policy=eyJTdGF0ZW1lbnQiOlt7IlJlc291cmNlIjoiaHR0cHM6Ly9jb21tdW5pdHktbWVkaWEubGlua2FyZWVyLmNvbS8qIiwiQ29uZGl0aW9uIjp7IkRhdGVMZXNzVGhhbiI6eyJBV1M6RXBvY2hUaW1lIjoxNzM5MDE5MjIyfX19XX0_&Key-Pair-Id=K355AZ2AKPMK1Z&Signature=APYFKB82efd6X7ZTy~TK4d4OI7EGHZ80f160P0buh5dqvarlamdo6gjg9fkDf6FYdCO0Z3EbKY5qZkWTZCTm6ZOM0j0~xIoEDcPccbrwtYMBkYaRo0j00oSf7XV1XvU0TWKAsoT1H4d6t2Ot3zKxcyHNU3YcVGQacn5GJrwMyQXIgcmaBGSP3yz4hRCBCMTx8HkVb9ksbrVL2YBKFzZiLZOsXMDFRFu9eOjCyLDtDVdYSyTIA5Y1SBTWtOaF7-qVw48Qcu6tVI79F6DvhHYMZhkHK~hFIGIn1Xhh5zTBVFqLBK0xmOfAS-rur9GbwMetU3a~7Extrhag5qPew7N~BA"
    val savePath = "src/main/kotlin/day16/image/test/single_image.jpg"
    repository.saveImage(imageUrl, savePath)
    println("Image saved to $savePath")

    // 여러 이미지 다운로드 및 저장
    val imageUrls = listOf(
        imageUrl,
        imageUrl,
        imageUrl
    )
    val saveDirectory = "src/main/kotlin/day16/image/test/"
    repository.saveImages(imageUrls, saveDirectory)
    println("Images saved to $saveDirectory")

    // 이미지가 없을 때만 다운로드하여 저장
    val result = repository.saveImageIfNotExists(imageUrl, savePath)
    println(if (result) "Image was downloaded and saved." else "Image already exists.")
}