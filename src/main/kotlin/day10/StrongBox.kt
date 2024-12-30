package org.example.day10

class StrongBox<E>(
    keyType: KeyType
) {
    private var data: E? = null
    private var count: Int = keyType.defaultCount

    fun put(value: E) {
        if (data != null) {
            throw IllegalStateException("금고에 이미 물건이 있습니다.")
        }
        data = value
    }

    fun get(): E? {
        if (count == 0) {
            return if (data == null) throw IllegalStateException("금고에 아무것도 없습니다.") else data

        }
        count -= 1
        return null
    }
}

enum class KeyType(val defaultCount: Int) {
    padlock(1024),
    button(10000),
    dial(30000),
    finger(1000000),
}
