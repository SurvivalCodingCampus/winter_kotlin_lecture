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