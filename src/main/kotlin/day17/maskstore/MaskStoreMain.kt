package org.hyunjung.day17.maskstore

import kotlinx.coroutines.runBlocking
import org.hyunjung.day17.maskstore.datasource.MaskStoreDataSource
import org.hyunjung.day17.maskstore.repository.MaskStoreRepository

fun main() = runBlocking {
    val repository = MaskStoreRepository(MaskStoreDataSource())
    val stores = repository.getStores()

    stores.forEach {
        println(it)
    }
}