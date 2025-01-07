package org.example.day15.repository_exam

import kotlinx.coroutines.runBlocking
import org.example.day15.repository_exam.data_source.PhotoDatasourceImpl
import org.example.day15.repository_exam.repository.PhotoRepositoryImpl

fun main() = runBlocking{
    val test = PhotoRepositoryImpl(PhotoDatasourceImpl())

    println(test.getPhotos(1))
    println(test.getPhotos(2))
    println(test.getPhotos(3))
    println(test.getPhotos(4))
}