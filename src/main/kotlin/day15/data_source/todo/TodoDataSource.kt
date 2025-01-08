package day15.data_source.todo

import day15.common.ResponseResult
import day15.model.Todo

interface TodoDataSource {

    // 전체 TODO 데이터 가져오기
    suspend fun getTodos(): ResponseResult<List<Todo>>
}


