package day16.exercise.datasource.todo

import utils.network.ResponseResult
import day15.model.Todo

interface TodoDataSource {

    // 전체 TODO 데이터 가져오기
    suspend fun getTodos(): ResponseResult<List<Todo>>

    // TODO 가져오기
    suspend fun getTodo(id: Int): ResponseResult<Todo>
}


