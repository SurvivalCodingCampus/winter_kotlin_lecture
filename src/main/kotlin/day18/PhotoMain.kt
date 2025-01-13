package org.hyunjung.day18

import kotlinx.coroutines.runBlocking
import org.hyunjung.day18.datasource.PhotoDataSourceImpl
import org.hyunjung.day18.repository.PhotoRepositoryImpl
import org.hyunjung.day18.util.Result

fun main() = runBlocking {
    val datasource = PhotoDataSourceImpl()
    val repository = PhotoRepositoryImpl(datasource)
    when (val photos = repository.getPhotos("yellow+flower")) {
        is Result.Error<*> -> {
            println(photos.message)
        }

        is Result.Success -> {
            photos.data.forEach {
                println(it)
            }
        }
    }
}