package org.example.day15.repository_exam

import kotlinx.coroutines.runBlocking
import org.example.day15.repository_exam.data_source.MockUserDatasourceImpl
import org.example.day15.repository_exam.repository.UserRepositoryImpl

fun main() = runBlocking {
    val test = UserRepositoryImpl(MockUserDatasourceImpl())

    println(test.getUsers())
    println(test.getUsersTop10ByUserName())
    test.getUsersTop10ByUserName().forEach { println(it.username) }
}