package org.example.day15.repository_exam

import kotlinx.coroutines.runBlocking
import org.example.day15.repository_exam.data_source.MockPostDatasourceImpl
import org.example.day15.repository_exam.repository.PostRepositoryImpl

fun main() = runBlocking {
    val test = PostRepositoryImpl(MockPostDatasourceImpl())

    val post = test.getPost(1)

    val allPosts = test.getPosts()

    val page1 = test.getPosts(1, 3)
    val page2 = test.getPosts(2, 3)
    val page3 = test.getPosts(3, 3)

    val wrongPage = test.getPosts(-1)

    val pageOne = test.getPosts(1)
    val pageTwo = test.getPosts(2, 3)

}