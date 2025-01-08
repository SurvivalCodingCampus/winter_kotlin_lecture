package day16.util

import day15.common.ResponseResult
import day16.exercise.datasource.image.ImageDataSourceImpl
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val testDataSource = ImageDataSourceImpl()
    val result = testDataSource.fetchImage("https://media.istockphoto.com/id/460758577/ko/%EC%82%AC%EC%A7%84/%EB%AF%B8%EC%96%B4%EC%BA%A3.jpg?s=2048x2048&w=is&k=20&c=6X5mMJERkkc-Tai8IYcZgN8gt1-SA1aEU6S8dpmiolE=")
    when (result) {
        is ResponseResult.Success -> {
            println("통신 성공")
            println(result.data)
        }

        is ResponseResult.Failure -> {
            println("통신 실패 ${result.exception.message}")
        }
    }
    println(result)
}