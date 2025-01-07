package org.hyunjung.day15.photo

import kotlinx.coroutines.runBlocking
import org.hyunjung.day15.photo.datasource.PhotoDataSourceImpl
import org.hyunjung.day15.photo.repository.PhotoRepositoryImpl

fun main() = runBlocking {
    val photoDataSource = PhotoDataSourceImpl()
    val repository = PhotoRepositoryImpl(photoDataSource)

    try {
        val photos = repository.getPhoto(1)
        println("Fetched Photos:")
        photos.forEach { println(it) }
    } catch (e: Exception) {
        println("Error fetching photos: ${e.message}")
    }
}