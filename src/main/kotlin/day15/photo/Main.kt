package org.hyunjung.day15.photo

import kotlinx.coroutines.runBlocking
import org.hyunjung.day15.photo.datasource.PhotoDataSourceImpl
import org.hyunjung.day15.photo.repository.PhotoRepositoryImpl

fun main() = runBlocking {
    val photoDataSource = PhotoDataSourceImpl()
    val repository = PhotoRepositoryImpl(photoDataSource)

    try {
        val comments = repository.getPhoto(1)
        println("Fetched Photos:")
        comments.forEach { println(it) }
    } catch (e: Exception) {
        println("Error fetching photos: ${e.message}")
    }
}