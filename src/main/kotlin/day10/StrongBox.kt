package org.example.day10

fun main() {
    val strongBox: StrongBox<Any> = StrongBox(KeyType.FINGER)
    val something1: Any = "money"
    val something2: Any = "gold"
    strongBox.put(something1)
    println(strongBox.get())
    println(strongBox.getTryCount())
    while (0 <= strongBox.getMaxTryCount()) {
        if (null != strongBox.get()) {
            println("사용횟수 : ${strongBox.getTryCount()} 금고안 인스턴스 : ${strongBox.get()} ")
            break
        }
    }
    strongBox.put(something2)
}

class StrongBox<Any>(
    keyType: KeyType
) {
    private var instance: Any? = null
        get() = field
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

    fun put(instance: Any) {
        if (instanceCount != 0) {
            this.instance = instance
            instanceCount--
        } else {
            throw IllegalArgumentException("이미 인스턴스가 1개 존재합니다")
        }
    }

    fun get() : Any? {
        if(maxTryCount != 0) {
            maxTryCount--
            tryCount++
            return null
        } else return instance
    }

    fun getMaxTryCount() = maxTryCount
    fun getTryCount() = tryCount
}

enum class KeyType {
    PADLOCK, BUTTON, DIAL, FINGER
}