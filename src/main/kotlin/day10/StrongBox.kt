package org.example.day10

enum class KeyType(val unlockCnt: Int) {
    PADLOCK(1_024),
    BUTTON(10_000),
    DIAL(30_000),
    FINGER(1_000_000),
}

enum class Error(val message: String) {
    EMPTY("금고가 비어 있습니다.")
}

class StrongBox<T : Any>(
    private val keyType: KeyType
) {
    private var getCnt: Int = 0
    private var item: T? = null

    fun put(item: T) {
        getCnt = 0
        this.item = item
    }

    fun get(): T? {
        require(item != null) { Error.EMPTY.message }

        getCnt += 1

        var result: T? = null
        if (keyType.unlockCnt <= getCnt) {
            result = item
            item = null
        }


        return result
    }
}