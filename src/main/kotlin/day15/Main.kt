package org.example.day15

import kotlinx.coroutines.runBlocking
import org.example.day15.data_source.*
import org.example.day15.repository.*


fun main() = runBlocking {

    val commentDataSource = CommentDataSourceImpl()
    val commentRepository = CommentRepositoryImpl(commentDataSource)
    val comments = commentRepository.getComments(1)
   // println(comments)

    val photoDataSource = PhotoDataSourceImpl()
    val photoRepository = PhotoRepositoryImpl(photoDataSource)
    val photoData = photoRepository.getPhotos(1)
    println(photoData.size)

    val todoDataSource = TodoDataSourceImpl()
    val todoRepository = TodoRepositoryImpl(todoDataSource)
    //println(todoRepository.getTodos())
    //println(todoRepository.getCompletedTodos())

    val userDataSource = UserDataSourceImpl()
    val userRepository = UserRepositoryImpl(userDataSource)
    //println(todoRepository.getTodos())
    //println(userRepository.getUsersTop10ByUserName())
//    userRepository.getUsersTop10ByUserName().forEach {
//        //println(it)
//    }

    val albumDataSource = AlbumDataSourceImpl()
    val albumRepository = AlbumRepositoryImpl(albumDataSource)
    //println(albumRepository.getAlbums())

    val postDataSource = PostDataSourceImpl()
    val postRepository = PostRepositoryImpl(postDataSource)
   // println(postRepository.getPosts())
/*    postRepository.getPosts(page = 1, limit = 3).forEach {
        println(it)
    }
    postRepository.getPosts(page = 2, limit = 3).forEach {
        println(it)
    }
    postRepository.getPosts(page = 3, limit = 3).forEach {
        println(it)
    }
    postRepository.getPosts(page = 0, limit = 3).forEach {
        println(it)
    }*/
}
