package com.survivalcoding.com.survivalcoding.day21

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

class FlowDemo {
    // cold
    fun flowFunc(): Flow<Int> = flow {
        var level = 1
        while (level <= 5) {
            delay(1000)
            emit(level++)
        }
    }
}

fun main() = runBlocking {
    val flowDemo = FlowDemo()
    val intFlow: Flow<Int> = flowDemo.flowFunc()

    flowOf(1, 2, 3).collect {
        println(it)
    }

    // 청우님 알려주세요
    intFlow.collect {
        println(it)
    }
}