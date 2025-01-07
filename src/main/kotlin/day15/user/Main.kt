package org.hyunjung.day15.user

import kotlinx.coroutines.runBlocking
import org.hyunjung.day15.user.datasource.UserDataSourceImpl
import org.hyunjung.day15.user.repository.UserRepositoryImpl

fun main() = runBlocking {
    val userDataSource = UserDataSourceImpl()
    val repository = UserRepositoryImpl(userDataSource)

    try {
        val todos = repository.getUsers()
        println("All Users:")
        todos.forEach { println(it) }
    } catch (e: Exception) {
        println("Error fetching photos: ${e.message}")
    }

    try {
        val todos = repository.getUsersTop10ByUserName()
        println("Users Top 10 by UserName:")
        todos.forEach { println(it) }
    } catch (e: Exception) {
        println("Error fetching photos: ${e.message}")
    }
}