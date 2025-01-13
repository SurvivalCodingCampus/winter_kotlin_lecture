package org.hyunjung.day17.photo

import kotlinx.coroutines.runBlocking
import org.hyunjung.day17.photo.datasource.MockPhotoDataSourceImpl
import org.hyunjung.day17.photo.repository.PhotoRepositoryImpl

fun main() = runBlocking {
    val repository = PhotoRepositoryImpl(MockPhotoDataSourceImpl())
    val photos = repository.getPhotos()

    photos.forEach {
        println(it)
    }
}