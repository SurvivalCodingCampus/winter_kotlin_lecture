package org.example.day15.repository_exam.repository

import org.example.day15.repository_exam.data_source.PostDatasource
import org.example.day15.repository_exam.model.Post

class PostRepositoryImpl(private val datasource: PostDatasource) : PostRepository {
    private var previousPage = 0
    private var previousLimit = 0

    override suspend fun getPost(id: Int): Post {
        return datasource.getPost(id)
    }

    override suspend fun getPosts(page: Int, limit: Int?): List<Post> {
        val listMaxSize = datasource.getAllPosts().size
        if (page <= 1) {
            previousPage = 1
            if (limit != null) {
                previousLimit += limit
                return datasource.getAllPosts().subList(0, limit)
            } else {
                previousLimit += listMaxSize
                return datasource.getAllPosts()
            }
        } else {
            previousPage = page

            if (previousLimit == listMaxSize) {
                return listOf()
            } else {
                if (limit != null) {
                    if (previousLimit + limit <= listMaxSize) {
                        previousLimit += limit
                        return datasource.getAllPosts().subList(previousLimit - limit, previousLimit)
                    } else {
                        return datasource.getAllPosts().subList(previousLimit, listMaxSize)
                    }
                } else {
                    return datasource.getAllPosts().subList(previousLimit, listMaxSize)
                }
            }
        }
    }
}