package org.hyunjung.day15.album

import kotlinx.coroutines.runBlocking
import org.hyunjung.day15.album.datasource.AlbumDataSourceImpl
import org.hyunjung.day15.album.repository.AlbumRepositoryImpl
import org.hyunjung.day15.photo.datasource.PhotoDataSourceImpl
import org.hyunjung.day15.photo.repository.PhotoRepositoryImpl

fun main() = runBlocking {
    val albumDataSource = AlbumDataSourceImpl()
    val repository = AlbumRepositoryImpl(albumDataSource)

    try {
        val albums = repository.getAlbums()
        println("All Albums:")
        albums.forEach { println(it) }
    } catch (e: Exception) {
        println("Error fetching photos: ${e.message}")
    }

    try {
        val albums = repository.getAlbums(3)
        println("Three Albums:")
        albums.forEach { println(it) }
    } catch (e: Exception) {
        println("Error fetching photos: ${e.message}")
    }
}