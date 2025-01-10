package org.example.day17

import kotlinx.coroutines.runBlocking
import org.example.day17.datasource.MockPhotoDataSourceImpl
import org.example.day17.datasource.StoreDataSourceImpl
import org.example.day17.repository.PhotoRepositoryImpl
import org.example.day17.repository.StoreRepositoryImpl

fun main() = runBlocking {
    val dataSource = StoreDataSourceImpl()
    val repo = StoreRepositoryImpl(dataSource)

    repo.getStores().forEach {
        //println(it)
    }


    val dataSource2 = MockPhotoDataSourceImpl()
    val repo2 = PhotoRepositoryImpl(dataSource2)

    repo2.getPhots().forEach {
        println(it)
    }
}