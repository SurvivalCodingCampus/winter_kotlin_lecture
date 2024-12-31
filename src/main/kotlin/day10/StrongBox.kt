package org.example.day10

fun main() {
    val strongBox: StrongBox<Any> = StrongBox(KeyType.FINGER)
    val something1: Any = "money"
    val something2: Any = "gold"
    strongBox.put(something1)
    println(strongBox.get())
    println(strongBox.getTryCount())
    while (0 <= strongBox.getMaxTryCount()) {
        val checkInstance = strongBox.get()
        if (null != checkInstance) {
            println("금고안 인스턴스 : ${checkInstance} 사용횟수 : ${strongBox.getTryCount()}")
            break
        }
    }
    strongBox.put(something2)
}

class StrongBox<T>(
    keyType: KeyType,
) {
    private var instance: T? = null
    private var instanceCount = INSTANCE_COUNT
    private var maxTryCount = 0
    private var tryCount = 0

    companion object {
        const val INSTANCE_COUNT = 1
    }

    init {
        keyCheck(keyType)
    }

    private fun keyCheck(keyType: KeyType) {
        maxTryCount = when (keyType) {
            KeyType.PADLOCK -> 1024
            KeyType.BUTTON -> 10000
            KeyType.DIAL -> 30000
            KeyType.FINGER -> 1000000
        }
    }

    fun put(instance: T) {
        if (instanceCount != 0) {
            this.instance = instance
            instanceCount--
        } else {
            throw IllegalArgumentException("이미 인스턴스가 1개 존재합니다")
        }
    }

    fun get(): T? {
        if (maxTryCount != 1) {
            maxTryCount--
            tryCount++
            return null
        } else {
            maxTryCount--
            tryCount++
            return instance
        }
    }

    fun getMaxTryCount() = maxTryCount
    fun getTryCount() = tryCount
}

enum class KeyType() {
    PADLOCK, BUTTON, DIAL, FINGER
}