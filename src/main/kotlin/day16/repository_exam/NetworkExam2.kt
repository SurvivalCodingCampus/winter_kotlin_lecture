package org.example.day16.repository_exam

import kotlinx.coroutines.runBlocking
import org.example.day16.repository_exam.data_source.image.ImageDataSourceImpl
import org.example.day16.repository_exam.repository.image.ImageRepositoryImpl
import java.io.File

fun main(): Unit = runBlocking {
    val imageRepository = ImageRepositoryImpl(ImageDataSourceImpl())
    val url = "https://i.pinimg.com/474x/87/a1/a3/87a1a3111c93a554bc768df6e225238c.jpg"
    val urls = File("image_urls.txt").readLines()
    val directory = "image_test_directory"

    if(File("${directory}/도지.jpg").exists()) File("${directory}/도지.jpg").delete()
    if(File("${directory}/도지11.jpg").exists()) File("${directory}/도지11.jpg").delete()
    if(File("${directory}/도지12.jpg").exists()) File("${directory}/도지12.jpg").delete()
    if(File("${directory}/도지13.jpg").exists()) File("${directory}/도지13.jpg").delete()
    if(File("${directory}/도지14.jpg").exists()) File("${directory}/도지14.jpg").delete()
    if(File("${directory}/도지15.jpg").exists()) File("${directory}/도지15.jpg").delete()
    if(File("${directory}/도지6.jpg").exists()) File("${directory}/도지6.jpg").delete()

    println(imageRepository.saveImage(url, "${directory}/도지.jpg"))

    println(imageRepository.saveImages(urls, directory))

    println(imageRepository.saveImageIfNotExists(url, "${directory}/도지6.jpg"))


//    File("${directory}/도지.jpg").delete()
//    File("${directory}/도지11.jpg").delete()
//    File("${directory}/도지12.jpg").delete()
//    File("${directory}/도지13.jpg").delete()
//    File("${directory}/도지14.jpg").delete()
//    File("${directory}/도지15.jpg").delete()
//    File("${directory}/도지6.jpg").delete()
}