package org.example.day15.repository_exam

import kotlinx.coroutines.runBlocking
import org.example.day15.repository_exam.data_source.MockAlbumDatasourceImpl
import org.example.day15.repository_exam.repository.AlbumRepositoryImpl

fun main() = runBlocking {
    val test = AlbumRepositoryImpl(MockAlbumDatasourceImpl())

    println(test.getAlbums().size)
    println(test.getAlbums(10).size)
    println(test.getAlbums(5).size)
}