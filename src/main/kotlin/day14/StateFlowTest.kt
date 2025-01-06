package org.example.day14

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import org.example.day14.data.model.Todo
import org.example.day14.data.repository.TodoDataSource
import org.example.day14.data.repository.TodoDataSourceImpl
import org.example.day14.data.result.Result
import org.example.day14.data.result.asResult

class TodoViewModel(
    private val todoDataSource: TodoDataSource,
    private val coroutineScope: CoroutineScope
) {
    private var _todoUiState: MutableStateFlow<TodoUIState> = MutableStateFlow(TodoUIState.Loading)

    val todoUiState: StateFlow<TodoUIState> = _todoUiState

    fun updateTodoState(url: String) {
        coroutineScope.launch {
            todoDataSource.getTodosFromUrl().asResult().map { result ->
                when (result) {
                    is Result.Success -> TodoUIState.Success(result.data)
                    is Result.Loading -> TodoUIState.Loading
                    is Result.Error -> TodoUIState.Error
                }
            }.stateIn(
                scope = coroutineScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = TodoUIState.Loading
            ).collect {
                _todoUiState.value = it
            }
        }
    }
}

sealed interface TodoUIState {
    data class Success(val todoList: List<Todo>) : TodoUIState
    data object Loading : TodoUIState
    data object Error : TodoUIState
}


// 종료가 안 된다.....
fun main(): Unit = runBlocking {
    val scope = CoroutineScope(Dispatchers.Default)
    val todoViewModel = TodoViewModel(
        TodoDataSourceImpl(),
        scope
    )

    todoViewModel.updateTodoState("https://jsonplaceholder.typicode.com/todos")
    todoViewModel.todoUiState.collect { result ->
        when (result) {
            is TodoUIState.Success -> {
                result.todoList.forEach {
                    println(it)
                }
            }

            TodoUIState.Error -> TODO()
            TodoUIState.Loading -> {
                println("로딩 중..")
            }
        }
    }
}