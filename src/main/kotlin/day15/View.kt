package org.example.day15

import kotlinx.coroutines.runBlocking
import org.example.day15.Repository.*

fun main(): Unit = runBlocking {
    val comments = CommentRepository().getComments(1)
    comments.forEach { comment -> println(comment.body) }

    val albums = AlbumRepository().getAlbums(30)
    albums.forEach { album ->
        println(album)
    }

    val photos = PhotoRepository().getPhotos(1)
    photos.forEach { photo ->
        println(photo.title)
    }

    val todos = TodoRepository().getTodos()
    todos.forEach { todo ->
        println(todo)
    }

    val completedTodo = TodoRepository().getCompletedTodos()
    completedTodo.forEach { todo ->
        println("compeleted $todo ")
    }

    val users = UserRepository().getUsers()

    val posts = PostRepository().getPost(1)
    posts.forEach {
        println(it)
    }


}