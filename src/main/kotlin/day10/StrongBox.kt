package org.hyunjung.day10

enum class KeyType(val maxAttempts: Long) {
    PADLOCK(1_024),
    BUTTON(10_000),
    DIAL(30_000),
    FINGER(1_000_000)
}

class StrongBox<T>(private val keyType: KeyType) {
    private var item: T? = null
    private var usageCount: Long = 0

    fun put(item: T) {
        this.item = item
    }

    fun get(): T? {
        if (usageCount >= keyType.maxAttempts) {
            return item
        }
        usageCount++
        return null
    }
}

fun main() {
    // StrongBox 테스트
    val padlockBox = StrongBox<String>(KeyType.PADLOCK)
    padlockBox.put("Treasure")

    repeat(1_024) { // 시도 횟수 제한까지 반복
        println("Attempt $it: ${padlockBox.get()}") // null 출력
    }
    println("Final Attempt: ${padlockBox.get()}") // Treasure 출력

    val fingerBox = StrongBox<Int>(KeyType.FINGER)
    fingerBox.put(42)
    println(fingerBox.get()) // null 출력 (1회 시도)
}