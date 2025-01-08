package day15.util

import day15.data_source.comment.MockCommentDataSourceImpl
import day15.data_source.photo.MockPhotoDataSourceImpl
import day15.data_source.post.MockPostDataSourceImpl
import day15.data_source.user.MockUserDataSourceImpl
import day15.repository.comment.CommentRepositoryImpl
import day15.repository.photo.PhotoRepositoryImpl
import day15.repository.post.PostRepositoryImpl
import day15.repository.user.UserRepositoryImpl
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val commentRepositoryImpl = CommentRepositoryImpl(MockCommentDataSourceImpl())

    val result = commentRepositoryImpl.getComments(1)

    //println(result)

    val photoRepositoryImpl = PhotoRepositoryImpl(MockPhotoDataSourceImpl())

    val result2 = photoRepositoryImpl.getPhotos(2)
    //println(result2)


    val userRepositoryImpl = UserRepositoryImpl(MockUserDataSourceImpl())

    val result3 = userRepositoryImpl.getUsersTop10ByUserName()
//    println(result3)
//    println(result3.size)


    val postRepositoryImpl = PostRepositoryImpl(MockPostDataSourceImpl())

    val result4 = postRepositoryImpl.getPosts(page = 2, limit = 3)
    println(result4)

}