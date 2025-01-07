package org.hyunjung.day15.post

import kotlinx.coroutines.runBlocking
import org.hyunjung.day15.post.datasource.PostDataSourceImpl
import org.hyunjung.day15.post.repository.PostRepositoryImpl

fun main() = runBlocking {
    val postDataSource = PostDataSourceImpl()
    val postRepository = PostRepositoryImpl(postDataSource)

    try {
        // 단일 포스트
        val post = postRepository.getPost(1)
        println("Post with ID 1:\n$post")

        // 전체 목록
        val allPosts = postRepository.getPosts()
        println("\nAll Posts:")
        allPosts.forEach { println(it) }

        // 페이지네이션
        val page1Posts = postRepository.getPosts(page = 1, limit = 3)
        println("\nPage 1, Limit 3 Posts:")
        page1Posts.forEach { println(it) }

        val page2Posts = postRepository.getPosts(page = 2, limit = 3)
        println("\nPage 2, Limit 3 Posts:")
        page2Posts.forEach { println(it) }

        // 잘못된 페이지 번호는 1로 처리
        val invalidPage = postRepository.getPosts(page = 0, limit = 3)
        println("\nInvalidPage 0, Limit 3 Posts:")
        invalidPage.forEach { println(it) }
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}