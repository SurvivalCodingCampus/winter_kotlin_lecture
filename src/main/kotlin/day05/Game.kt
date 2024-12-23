package com.survivalcoding.day05

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

// 게임 캐릭터의 상태 변화를 Flow로 표현
class GameCharacter(val name: String) {
    // 레벨업 이벤트를 발생시키는 Flow
    fun experienceFlow() = flow {
        var level = 1
        while (level <= 5) {
            delay(1000) // 1초마다 레벨업
            emit(level++)
        }
    }

    // HP 변화를 발생시키는 Flow
    fun hpFlow() = flow {
        var hp = 100
        while (hp > 0) {
            delay(500) // 0.5초마다 HP 감소
            hp -= 10
            emit(hp)
        }
    }
}

fun main() = runBlocking {
    val hero = GameCharacter("용사")

    // 레벨업 관찰
    hero.experienceFlow()
        .onEach { level -> println("${hero.name}가 ${level}레벨이 되었습니다!") }
        .launchIn(this)

    // HP 변화 관찰
    hero.hpFlow()
        .onEach { hp -> println("${hero.name}의 현재 HP: $hp") }
        .filter { hp -> hp < 50 }  // HP가 50 미만일 때만
        .onEach { println("${hero.name}가 위험합니다!") }
        .launchIn(this)

    delay(5000) // 5초 동안 관찰

    setOf(1).iterator().forEach { }
}