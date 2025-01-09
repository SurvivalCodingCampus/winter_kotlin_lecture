package org.example.day17

import kotlinx.coroutines.runBlocking
import org.example.day17.datasource.StoreDataSourceImpl
import org.example.day17.repository.StoreRepositoryImpl

fun main() = runBlocking {
    val dataSource = StoreDataSourceImpl()
    val repo = StoreRepositoryImpl(dataSource)

    repo.getStores().forEach {
        println(it)
    }
}