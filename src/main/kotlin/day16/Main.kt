package org.example.day16

import kotlinx.coroutines.runBlocking
import org.example.day16.datasource.ImageDataSourceImpl
import org.example.day16.datasource.MovieMockDataSourceImpl
import org.example.day16.repository.ImageRepositoryImpl
import org.example.day16.repository.MovieRepositoryImpl

fun main() = runBlocking{
    val dataSource = MovieMockDataSourceImpl()
    val repository = MovieRepositoryImpl(dataSource)

    //println(repository.getMovieInfoList())

   // val imageDataSource = ImageDataSourceImpl()
    //val imageRepo = ImageRepositoryImpl(imageDataSource)
    //imageRepo.saveImage("https://w7.pngwing.com/pngs/660/539/png-transparent-leaf-gratis-leaves-watercolor-leaves-branch-banana-leaves-thumbnail.png","day16")

    val imageDataSource = ImageDataSourceImpl()
    val imageRepository = ImageRepositoryImpl(imageDataSource)

    // 단일 이미지 저장
    //imageRepository.saveImage("https://cdn.pixabay.com/photo/2025/01/07/11/07/squirrel-9316805_640.jpg", "image.jpg")

    // 여러 이미지 저장
    imageRepository.saveImages(
        listOf(
            "https://cdn.pixabay.com/photo/2025/01/07/16/23/robin-9317266_1280.jpg",
            "https://cdn.pixabay.com/photo/2025/01/07/16/43/peanuts-9317291_640.jpg",
            "https://cdn.pixabay.com/photo/2025/01/07/14/55/ai-generated-9317145_640.png"
        ),
        "images" // 디렉토리 이름
    )

    // 이미지가 없을 때만 저장
    val isSaved = imageRepository.saveImageIfNotExists("https://example.com/image.jpg", "image1.jpg")
    println("이미지가 저장되었는지: $isSaved")
}